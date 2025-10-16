import java.util.Scanner;

public class Main_2431 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int secim;
		int sayi, basamakSayisi = 0;

		int bolenlertoplami;
		do {
			System.out.println("Menu 1: İşlem a) ");
			System.out.println("Menu 2: İşlem b)");
			System.out.println("Menu 3: İşlem c)");
			System.out.println("Menu -1: Çıkış)");
			System.out.print("İşlem tipi seçiniz:");
			secim = scanner.nextInt();
			switch (secim) {
			case (1):
				System.out.print("Bölen toplamını bulmak istediğiniz sayıyı giriniz:");
				sayi = scanner.nextInt();
				bolenlertoplami = BolenlerToplaminiHesapla(sayi);
				System.out.println("Bölenler Toplamı :" + bolenlertoplami);
				break;
			case (2):
				do {
					System.out.print("Hangi basamaktaki(N) arkadaş sayıları bulmak istiyorsunuz?(N>2):");
					basamakSayisi = scanner.nextInt();
					if (basamakSayisi <= 2) {
						System.out.println("Geçerli bir basamak sayısı giriniz.");

					}
				} while (basamakSayisi <= 2);
				ArkadasSayilariBul(basamakSayisi);
				break;
			case (3):
				EnYakinSayiCiftiVeBolenleriGoster(basamakSayisi);
				break;
			case (-1):
				System.out.println("Çıkış Yapıldı.");
				break;
			default:
				System.out.println("Geçersiz Seçim. Tekrar deneyiniz!!");
			}
		} while (secim != -1);

	}

	public static int BolenlerToplaminiHesapla(int sayi) {
		int toplam = 1;
		for (int i = 2; i < sayi; i++) {
			if (sayi % i == 0) {
				toplam += i;
			}
		}
		return toplam;
	}

	public static void ArkadasSayilariBul(int N) {
		int sayi1 = 1, sayi2 = 1;
		for (int i = 1; i < N; i++) {
			sayi1 *= 10;

		}
		for (int i = 1; i <= N; i++) {
			sayi2 *= 10;
		}
		sayi2 -= 1;
		for (int i = sayi1; i <= sayi2; i++) {
			int bolenToplami = BolenlerToplaminiHesapla(i);
			int bolenToplamininBolenToplami = BolenlerToplaminiHesapla(bolenToplami);
			if (i == bolenToplamininBolenToplami && i < bolenToplami) {
				System.out.println(i + " ve " + bolenToplami + " arkadaş Sayılardır.");

			}
		}

	}

	public static void EnYakinSayiCiftiVeBolenleriGoster(int basamakSayisi) {
		int enkucuk = 1000000;
		int fark, i, arkadasSayi1 = 0, arkadasSayi2 = 0;

		int bolenToplami, bolenToplamininBolenToplami;

		int sayi1 = 1, sayi2 = 1;
		for (int j = 1; j < basamakSayisi; j++) {
			sayi1 *= 10;

		}
		for (int j = 1; j <= basamakSayisi; j++) {
			sayi2 *= 10;
		}
		sayi2 -= 1;
		for (i = sayi1; i <= sayi2; i++) {
			bolenToplami = BolenlerToplaminiHesapla(i);
			if (i < bolenToplami ) {
				bolenToplamininBolenToplami = BolenlerToplaminiHesapla(bolenToplami);

				if (i == bolenToplamininBolenToplami) {
					fark = bolenToplami - i;
					if (fark < enkucuk) {
						enkucuk = fark;
						arkadasSayi1 = i;
						arkadasSayi2 = bolenToplami;
					}
				}
			}
		}
		System.out.println("Birbirine en yakın sayı çiftleri: " + arkadasSayi1 + " ve " + arkadasSayi2);
		arkadasSayilarinBolenleri(arkadasSayi1, arkadasSayi2);

	}

	public static void arkadasSayilarinBolenleri(int arkadasSayi1, int arkadasSayi2) {
		System.out.print(arkadasSayi1 + ". Sayının Bölenleri: ");
		for (int i = 1; i < arkadasSayi1; i++) {

			if (arkadasSayi1 % i == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.print(arkadasSayi2 + ". Sayının Bölenleri: ");
		for (int i = 1; i < arkadasSayi2; i++) {
			if (arkadasSayi2 % i == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

	}

}
