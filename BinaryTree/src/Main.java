
public class Main {

	public static void main(String[] args) {
		// top node
		Node fifteen = new Node(15);

		// left side nodes
		Node seven = new Node(7);
		Node six = new Node(6);
		Node twelve = new Node(12);
		Node five = new Node(5);
		Node ten = new Node(10);

		// right side nodes
		Node twenty = new Node(20);
		Node eighteen = new Node(18);
		Node twentyTwo = new Node(22);
		Node sixteen = new Node(16);
		Node nineteen = new Node(19);
		Node twentyFive = new Node(25);


		// setting left side nodes
		fifteen.setLeft(seven);
		seven.setLeft(six);
		seven.setRight(twelve);
		six.setLeft(five);
		twelve.setLeft(ten);

		// setting right side nodes
		fifteen.setRight(twenty);
		twenty.setLeft(eighteen);
		eighteen.setLeft(sixteen);
		eighteen.setRight(nineteen);
		twenty.setRight(twentyTwo);
		twentyTwo.setRight(twentyFive);

		// testing methods
		findMaxValue(fifteen);
		findMinValue(fifteen);
		findNode(fifteen, 25);

	}

	public static int findMaxValue(Node node) {
		int max = 0;
		boolean moreNodes = true;
		if (node == null) {
			System.out.println("Node is null");
			return 0;
		}
		while (moreNodes == true) {
			if (node.getRight() != null) {
				max = node.getRight().getValue();
				node = node.getRight();
				moreNodes = true;
			} else if (node.getLeft() != null) {
				max = node.getLeft().getValue();
				node = node.getLeft();
				moreNodes = true;
			} else {
				moreNodes = false;
			}
		}

		System.out.println(max);
		return max;
	}

	public static int findMinValue(Node node) {
		int min = 0;
		boolean moreNodes = true;
		if (node == null) {
			System.out.println("Node is null");
			return 0;
		}
		while (moreNodes == true) {
			if (node.getLeft() == null) {
				min = node.getValue();
				System.out.println(min);
				return min;
			} else if (node.getLeft() != null) {
				min = node.getLeft().getValue();
				node = node.getLeft();
				moreNodes = true;
			} else {
				moreNodes = false;
			}
		}
		return min;
	}

	public static void findNode(Node startingNode, int findNumber) {
		boolean moreNodes = true;
		while (moreNodes == true) {
			try {
				// seeing if the starting node is the number we're looking for
				if (findNumber == startingNode.getValue()) {
					System.out.println(findNumber + " is in the Binary Tree");
					moreNodes = false;

					// traversing left side of the tree
				} else if (findNumber < startingNode.getValue()) {
					findNode(startingNode.getLeft(), findNumber);
					moreNodes = false;

					// traversing right side of the tree
				} else if (findNumber > startingNode.getValue()) {
					findNode(startingNode.getRight(), findNumber);
					moreNodes = false;

				} else {
					System.out.println(findNumber + " is NOT in the Binary Tree");
					moreNodes = false;

				}
			} catch (Exception e) {
				System.out.println(findNumber + " is NOT in the Binary Tree");
				moreNodes = false;
			}

		}

	}
}
