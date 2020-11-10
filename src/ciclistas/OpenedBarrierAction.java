package ciclistas;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class OpenedBarrierAction implements Runnable {

	private int etapa=0;
	@Override
	public void run() {
		
		if(etapa==0) {
			System.out.printf("%s: Comenzamos la etapa a las %s\n",
					Thread.currentThread().getName(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
			etapa++;
		}
		else if(etapa==1) {
			System.out.printf("%s: Vamos todos de vuelta a casa a las %s\n",
					Thread.currentThread().getName(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
			etapa++;
		}
		else if(etapa==2) {
			System.out.printf("%s: La etapa ha finalizado a las %s\n",
					Thread.currentThread().getName(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
		}
		
	}

}
