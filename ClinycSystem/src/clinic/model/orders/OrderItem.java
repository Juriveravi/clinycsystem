package clinic.model.orders;

import clinic.enums.OrderItemType;

public abstract class OrderItem {

    protected int itemNumber;
    protected String name;
    protected double cost;
    protected OrderItemType type;

    public OrderItemType getType() {
        return type;
    }

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setType(OrderItemType type) {
		this.type = type;
	}
}