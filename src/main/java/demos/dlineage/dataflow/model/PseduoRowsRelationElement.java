
package demos.dlineage.dataflow.model;

import gudusoft.gsqlparser.ESqlClause;

public class PseduoRowsRelationElement<T extends PseduoRows<?>> implements RelationElement<T> {

	private T rseduoRows;

	private ESqlClause relationLocation;

	public PseduoRowsRelationElement(T rseduoRows) {
		this.rseduoRows = rseduoRows;
	}

	public PseduoRowsRelationElement( T rseduoRows,
			ESqlClause relationLocation )
	{
		this.rseduoRows = rseduoRows;
		this.relationLocation = relationLocation;
	}

	@Override
	public T getElement() {
		return rseduoRows;
	}

	public ESqlClause getRelationLocation() {
		return relationLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rseduoRows == null) ? 0 : rseduoRows.hashCode());
		result = prime * result + ((relationLocation == null) ? 0 : relationLocation.hashCode());
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
		PseduoRowsRelationElement<?> other = (PseduoRowsRelationElement<?>) obj;
		if (rseduoRows == null) {
			if (other.rseduoRows != null)
				return false;
		} else if (!rseduoRows.equals(other.rseduoRows))
			return false;
		if (relationLocation != other.relationLocation)
			return false;
		return true;
	}

}
