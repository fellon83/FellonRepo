package esami.Lab20150203;

public class Voto {

	TipoVoto voto;
	private ListaElettorale lista = null;

	public Voto(ListaElettorale s) {
		if (s == null) {
			voto = TipoVoto.NULLA;
		} else {

			this.lista = s;
			voto = TipoVoto.VALIDA;
		}

	}

	public Voto() {
		voto = TipoVoto.BIANCA;
	}

	public boolean nullo() {
		return voto == TipoVoto.NULLA;
	}

	public boolean bianca() {
		return voto == TipoVoto.BIANCA;
	}

	public ListaElettorale voto() {
		if (!nullo() && !bianca()) {
			return lista;
		} else {
			return null;
		}
	}

	public TipoVoto getVotoValido() {
		return voto;
	}
}
