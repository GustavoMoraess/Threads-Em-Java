package curso_java.aula74.labs;
public enum CorSemaforo {	
	VERDE(1000), AMARELO(300), VERMELHO(2000);
	private int tempoEspera;
	CorSemaforo(int tempoEspera){
            this.tempoEspera = tempoEspera;
	}
	public int getTempoEspera() {
            return tempoEspera;
	}
}
