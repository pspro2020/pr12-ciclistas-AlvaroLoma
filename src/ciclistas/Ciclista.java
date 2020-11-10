package ciclistas;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Ciclista implements Runnable {
	
	private final CyclicBarrier cyclicBarier;
	private Random rng= new Random();

	public Ciclista(CyclicBarrier cyclicBarier) {
		
		this.cyclicBarier = cyclicBarier;
	}

	@Override
	public void run() {
		
		try {
			salgoDeCasa();
		} catch (InterruptedException e) {
			System.out.printf(" me han interrumpido cuando salia de casa");
			return;
		}
		try {
			cyclicBarier.await();
		} catch (InterruptedException e) {
			System.out.println("Nos han interrimpido mientras esperabamos");
		} catch (BrokenBarrierException e) {
			System.out.println("No espero mas");
		}
		
		try {
			irALaVenta();
		} catch (InterruptedException e) {
			System.out.println("Me han interrumpido cuando iba a la venta");
		}
		
		try {
			cyclicBarier.await();
		} catch (InterruptedException e) {
			System.out.println("Me han interrumpido cuando esperaba");
		} catch (BrokenBarrierException e) {
			System.out.println("No espero mas");
		}
		try {
			volverAGasolinera();
		} catch (InterruptedException e) {
			System.out.println("Me han interrumpido cuando volvia de la gasolinera");
		}
		try {
			cyclicBarier.await();
		} catch (InterruptedException e) {
			System.out.println("Me han interrumpido esperando");
		} catch (BrokenBarrierException e) {
			System.out.println("No espero mas");
		}
		
		try {
			volverACasa();
		} catch (InterruptedException e) {
			System.out.println("Me han interrumpido cuando volvia a casa");
		}
		
	}

	private void volverACasa() throws InterruptedException {
		System.out.printf("%s: Estoy volviendo a casa a las %s\n",
				Thread.currentThread().getName(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
		TimeUnit.SECONDS.sleep(rng.nextInt(3)+1);
		System.out.printf("%s: He llegado a casa a las %s\n",
				Thread.currentThread().getName(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
		
		
	}

	private void volverAGasolinera() throws InterruptedException {
		System.out.printf("%s: Estoy volviendo a la gasolinera a las %s\n",
				Thread.currentThread().getName(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
		TimeUnit.SECONDS.sleep(rng.nextInt(5)+5);
		System.out.printf("%s: He vuelto a la gasolinera y estoy esperando a mis compañeros a las %s\n",
				Thread.currentThread().getName(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
		
		
	}

	private void irALaVenta() throws InterruptedException {
		System.out.printf("%s: Estoy yendo a la venta a las %s\n",
				Thread.currentThread().getName(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
		TimeUnit.SECONDS.sleep(rng.nextInt(5)+5);
		System.out.printf("%s: He llegado a la venta y espero a mis compañeros a las %s\n",
				Thread.currentThread().getName(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
		
		
	}

	private void salgoDeCasa() throws InterruptedException {
		System.out.printf("%s: Estoy saliendo de casaa las %s\n",
				Thread.currentThread().getName(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
		TimeUnit.SECONDS.sleep(rng.nextInt(3)+1);
		System.out.printf("%s: Llego a la gasolinera y espero a mis compañeros a las %s\n",
				Thread.currentThread().getName(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
		
		
		
	}

}
