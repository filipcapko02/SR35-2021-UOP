package Clan;

import java.time.LocalDate;
import java.util.ArrayList;

public class Nezaposlen extends Clan {
	
	protected String brCK;
	protected Clanarina clanarina;
	protected LocalDate datumPU;
	protected int brojMeseci;
	protected Aktivan aktivan;
	
	public Nezaposlen() {
		this.brCK = "";
		this.datumPU = null;
		this.brojMeseci = 0;
	}
	
	public String getBrCK() {
		return brCK;
	}

	public void setBrCK(String brCK) {
		this.brCK = brCK;
	}

	public Clanarina getClanarina() {
		return clanarina;
	}

	public void setClanarina(Clanarina clanarina) {
		this.clanarina = clanarina;
	}

	public LocalDate getDatumPU() {
		return datumPU;
	}

	public void setDatumPU(LocalDate datumPU) {
		this.datumPU = datumPU;
	}

	public int getBrojMeseci() {
		return brojMeseci;
	}

	public void setBrojMeseci(int brojMeseci) {
		this.brojMeseci = brojMeseci;
	}

	public Aktivan getAktivan() {
		return aktivan;
	}

	public void setAktivan(Aktivan aktivan) {
		this.aktivan = aktivan;
	}

	public Nezaposlen(String brCK,Clanarina clanarina,
			LocalDate datumPU,int brojMeseci,
			Aktivan aktivan) {
		super();
		this.brCK = brCK;
		this.clanarina = clanarina;
		this.datumPU = datumPU;
		this.brojMeseci = brojMeseci;
		this.aktivan = aktivan;
		
	}
	
	public Nezaposlen(Nezaposlen original) {
		this.brCK = original.brCK;
		this.clanarina = original.clanarina;
		this.datumPU = original.datumPU;
		this.brojMeseci = original.brojMeseci;
		this.aktivan = original.aktivan;
	}

}
