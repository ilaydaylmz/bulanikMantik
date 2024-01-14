// Sakarya Üniversitesi Bilgisayar Mühendisliği Bölümü
// 2023-2024 Öğretim Yılı Bulanık Mantık ve Yapay Sinir Ağların Giriş Dersi 1. Ödev
// ilayda YILMAZ B201210057 1A Grubu


package deneme;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class Sertlik {
	
	private final FIS fis;
	private final double sogumaHizi;
	private final double sudaBekletilmeSuresi;
	public Sertlik(double sogumaHizi,double sudaBekletilmeSuresi) throws URISyntaxException{
		this.sudaBekletilmeSuresi=sudaBekletilmeSuresi;
		this.sogumaHizi=sogumaHizi;
		File file =new File(getClass().getResource("CelikModel.fcl").toURI());
		fis=FIS.load(file.getPath(),true);
		fis.setVariable("sogumaHiz",sogumaHizi);
		fis.setVariable("sudaBekletilmeSure",sudaBekletilmeSuresi);
		fis.evaluate();
	}
	@Override
	public String toString() {
		return "Çelik sertliği:" +Math.round(fis.getVariable("sertlik").getValue())+"Vickers";
	}
	public FIS getModel() {
		return fis;
	}

}
