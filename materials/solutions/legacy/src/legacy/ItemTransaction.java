package legacy;

public class ItemTransaction {

	public enum Type {
		SALE, RETURN, SCRAP
	}

	Type type;
	int itemId;

	public ItemTransaction(Type type, int itemId) {
		this.type = type;
		this.itemId = itemId;
	}

	public ItemTransaction(Type type, Item item) {
		this(type, item.getId());
	}

	public Type getType() {
		return type;
	}

	public int getItemId() {
		return itemId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemTransaction other = (ItemTransaction) obj;
		if (itemId != other.itemId)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
