package ciclistas;

import java.util.concurrent.CyclicBarrier;

public class Main {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(10,new OpenedBarrierAction());
		
		for (int i = 0; i < 10; i++) {
			new Thread(new Ciclista(cyclicBarrier)).start();
		}

	}

}
