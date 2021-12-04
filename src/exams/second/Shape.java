package exams.second;

import java.util.Objects;

public abstract class Shape {
	
	protected String name;

	public Shape() {
		this.name = "shape";
	}

	public Shape(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Shape [name=" + name + "]";
	}
	
	public abstract double area();
	
	public abstract double perimeter();
	
	
	

}
