import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Exercise1 exercise1;

		try {
			int width = Integer.parseInt(args[0]);
			int length = Integer.parseInt(args[1]);
			exercise1 = new Exercise1(width, length);

		} catch (InputMismatchException e) {
			System.out.println("Command-line arguments must be natural numbers");
			return;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please provide command-line arguments for the width and length");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		exercise1.printArray();

		while (true) {

			int option = nextOption();

			switch (option) {
				case 1:
					System.out.print("Enter search string: ");
					String substr = scanner.nextLine();

					exercise1.searchArray(substr);
					break;

				case 2:
					editExercise1(exercise1);
					exercise1.printArray();
					break;

				case 3:
					exercise1.printArray();
					break;

				case 4:
					exercise1 = resetExercise1();
					exercise1.printArray();
					break;
				case 5:
					System.out.println("Program terminated");
					System.exit(0);
			}
		}
	}

	public static int nextOption() {
		int option;

		while (true) {
			try {
				System.out.println("[1] Search, [2] Edit, [3] Print, [4] Reset, [5] Exit");
				System.out.print("Option: ");
				option = scanner.nextInt();

				if (option < 1 || option > 5) {
					throw new InputMismatchException();	
				}

				break;
			} catch (InputMismatchException e) {
				System.out.println("Value must be an integer between 1 and 5.");
				scanner.nextLine(); // Consume new-line leftover so that nextInt can appropriately 
									// grab next input.
			}  catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

		scanner.nextLine(); // Consume new-line leftover from nextInt().

		return option;
	}

	public static void editExercise1(Exercise1 exercise1) {

		System.out.print("Enter new string: ");
		String str = scanner.nextLine();

		int x, y;

		while (true) {
			try {
				System.out.print("Enter x: ");
				x = scanner.nextInt();

				if (x < 0 || x >= exercise1.getArrayWidth()) {
					throw new InputMismatchException();
				}

				break;

			} catch (InputMismatchException e) {
				System.out.println(
					"Value must be an integer between 0 (inclusive) and " + 
					exercise1.getArrayWidth() + " (exclusive)"
				);
				scanner.nextLine(); // Consume new-line leftover so that nextInt can appropriately 
									// grab next input.
			}  catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

		while (true) {
			try {
				System.out.print("Enter y: ");
				y = scanner.nextInt();

				if (y < 0 || y >= exercise1.getArrayLength()) {
					throw new InputMismatchException();
				}

				break;

			} catch (InputMismatchException e) {
				System.out.println("Value must be an integer between 0 (inclusive) and " + 
					exercise1.getArrayLength() + " (exclusive)"
				);
				scanner.nextLine(); // Consume new-line leftover so that nextInt can appropriately 
									// grab next input.
			}  catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

		exercise1.editArray(x, y, str);
	}

	public static Exercise1 resetExercise1() {

		int width, length;

		while (true) {
			try {
				System.out.print("Enter width: ");
				width = scanner.nextInt();

				if (width <= 0) {
					throw new InputMismatchException();
				}

				break;

			} catch (InputMismatchException e) {
				System.out.println("Value must be a natural number.");
				scanner.nextLine(); // Consume new-line leftover so that nextInt can appropriately 
									// grab next input.
			}  catch (Exception e) {
				System.out.println("Unknown Error");
				scanner.nextLine();
			}
		}
		
		while (true) {
			try {
				System.out.print("Enter length: ");
				length = scanner.nextInt();

				if (length <= 0) {
					throw new Exception();
				}

				break;

			} catch (InputMismatchException e) {
				System.out.println("Value must be a natural number.");
				scanner.nextLine(); // Consume new-line leftover so that nextInt can appropriately 
									// grab next input.
			}  catch (Exception e) {
				System.out.println("Unknown Error");
				scanner.nextLine();
			}
		}

		
		return new Exercise1(width, length);
	}
}