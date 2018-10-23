import java.util.Random;

public class Exercise1 {
	
	private String[][] array;

	public Exercise1(int width, int length) {
		array = new String[width][length];

		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				array[x][y] = getRandomString();
			}
		}
	}

	public int getArrayWidth() {
		return array.length;
	}

	public int getArrayLength() {
		return array[0].length;
	}

	public void printArray() {
		for (int y = 0, i = getArrayLength(); y < i; y++) {
			for (int x = 0, j = getArrayWidth(); x < j; x++) {
				
				if (x != 0) {
					System.out.print("| ");
				}

				System.out.print(array[x][y] + " ");
			}

			System.out.println();
		}

		System.out.println();
	}

	public boolean editArray(int x, int y, String str) {
		if (x < 0 || y < 0 || x >= getArrayWidth() || y >= getArrayLength()) {
			return false;
		}

		array[x][y] = str;

		return true;
	}

	public void searchArray(String substr) {
		for (int y = 0, i = getArrayLength(); y < i; y++) {
			for (int x = 0, j = getArrayWidth(); x < j; x++) {

				int s = array[x][y].length() - substr.length();

				// substr length is equal or longer than the string to be searched. Hence, continue.
				if (s <= 0) {
					continue;
				}

				int count = 0;

				for (int k = 0; k <= s; k++) {
					if (array[x][y].substring(k, k + substr.length()).equals(substr)) {
						count++;
					}
				}

				if (count > 0) {
					System.out.printf("%d instance/s is found at (%d, %d)\n", count, x, y);
				}
			}
		}

		System.out.println();
	}

	private String getRandomString() {
		StringBuilder sb = new StringBuilder();

		Random rnd = new Random();

		for (int i = 0; i < 5; i++) {
			// ascii character between 0 ~ 31 represent symbols not found in the keyboard. Also, 127 
			// ascii is an empty character. Hence, allowed ascii range is between 32 ~ 126 only.
			int ascii = rnd.nextInt(127 - 32) + 32; 
			sb.append((char) ascii);
		}

		return sb.toString();
	}
}