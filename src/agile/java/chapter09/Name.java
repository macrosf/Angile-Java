package agile.java.chapter09;

public class Name {

	private String name;

	public Name(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object that) {
		if (that == null || that.getClass() != this.getClass())
			return false;
		return this.name.equals( ((Name)that).name );
	}

	@Override
	public int hashCode() {
		final int hashMultiplier = 41;
		int result = 7;
		result = result * hashMultiplier + name.hashCode();
		return result;
	}
}

