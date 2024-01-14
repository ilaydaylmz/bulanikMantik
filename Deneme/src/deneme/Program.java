// Sakarya Üniversitesi Bilgisayar Mühendisliği Bölümü
// 2023-2024 Öğretim Yılı Bulanık Mantık ve Yapay Sinir Ağların Giriş Dersi 1. Ödev
// ilayda YILMAZ B201210057 1A Grubu


package deneme;

import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double sogumaHizi;
		double sudaBekletilmeSuresi;
		Scanner in =new Scanner(System.in);
		
		do {
			System.out.print("Soğuma hızı [30,150]:");
			sogumaHizi = in.nextDouble();
			if(sogumaHizi<30 || sogumaHizi>150)
			{
				System.out.println("Soğuma hızı hatalı girildi.");
			}
		}
		while(sogumaHizi<=30 || sogumaHizi>=150);
		
		do {
			System.out.print("Suda bekletilme süresi[600,36000]:");
			sudaBekletilmeSuresi = in.nextDouble();
			if(sudaBekletilmeSuresi<600 || sudaBekletilmeSuresi>36000)
			{
				System.out.println("Suda bekletilme süresi hatalı girildi.");
			}
		}
		while(sudaBekletilmeSuresi <600 || sudaBekletilmeSuresi>36000);
		
		try {
			Sertlik sertlik =new Sertlik (sogumaHizi,sudaBekletilmeSuresi);
			var kurallar=sertlik.getModel().getFunctionBlock("CelikModel").getFuzzyRuleBlock("kuralBlok1").getRules();
			for(var kural:kurallar) {
				if(kural.getDegreeOfSupport()>0) {
					System.out.println(kural);
				}
			}
			System.out.print(sertlik);
			JFuzzyChart.get().chart(sertlik.getModel());
			JFuzzyChart.get().chart(sertlik.getModel().getVariable("sertlik").getDefuzzifier(),"Sertlik",true);
		}
		catch(Exception e){
			System.out.print(e.getMessage());
		
		}
		
	}
}

