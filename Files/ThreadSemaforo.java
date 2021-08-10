package curso_java.aula74.labs;
import com.sun.swing.internal.plaf.synth.resources.synth;
public class ThreadSemaforo implements Runnable {
	private CorSemaforo cor;
	private boolean parar;
	private boolean corMudou;
	public ThreadSemaforo(){
		this.cor = CorSemaforo.VERMELHO;
		this.parar = false;
		this.corMudou = false;
		new Thread(this).start();
	}
	@Override
	public void run() {
		while(!parar){
			try {
				/*switch (this.cor) {
				case VERMELHO:
					Thread.sleep(2000);
					break;
				case AMARELO:
					Thread.sleep(300);
					break;
				case VERDE:
					Thread.sleep(1000);
					break;
				default:
					break;
				}*/
				Thread.sleep(this.cor.getTempoEspera());
				this.mudarCor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private synchronized void mudarCor(){
		switch (this.cor) {
		case VERMELHO:
			this.cor = CorSemafaro.VERDE;
			break;
		case AMARELO:
			this.cor = CorSemafaro.VERMELHO;
			break;
		case VERDE:
			this.cor = CorSemafaro.AMARELO;
			break;
		default:
			break;
		}
		this.corMudou = true;
		notify();
	}	
	public synchronized void esperaCorMudar(){
		while(!this.corMudou){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.corMudou = false;
	}
	public synchronized void desligarSemaforo(){
		this.parar = true;
	}
	public CorSemaforo getCor() {
		return cor;
	}
}
