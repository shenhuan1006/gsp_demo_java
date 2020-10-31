package gudusoft.gsqlparser.dlineage.dataflow.model;

import gudusoft.gsqlparser.EParameterMode;
import gudusoft.gsqlparser.TSourceToken;
import gudusoft.gsqlparser.dlineage.util.Pair3;
import gudusoft.gsqlparser.nodes.TParameterDeclaration;
import gudusoft.gsqlparser.nodes.TTypeName;

public class Argument {
	private Procedure procedure;
	private int id;
	private String name;
	private Pair3<Long, Long, String> startPosition;
	private Pair3<Long, Long, String> endPosition;
	private TParameterDeclaration parameterObject;
	private EParameterMode mode;
	private TTypeName dataType;

	public Argument(Procedure procedure, TParameterDeclaration parameterObject) {
		if (procedure != null && parameterObject != null) {
			this.id = ++ModelBindingManager.get().TABLE_COLUMN_ID;
			this.parameterObject = parameterObject;
			TSourceToken startToken = parameterObject.getStartToken();
			TSourceToken endToken = parameterObject.getEndToken();
			this.startPosition = new Pair3<Long, Long, String>(startToken.lineNo, startToken.columnNo, ModelBindingManager.getGlobalHash());
			this.endPosition = new Pair3<Long, Long, String>(endToken.lineNo,
					endToken.columnNo + (long) endToken.astext.length(), ModelBindingManager.getGlobalHash());
			if (parameterObject.getParameterName().getColumnNameOnly() != null
					&& !"".equals(parameterObject.getParameterName().getColumnNameOnly())) {
				this.name = parameterObject.getParameterName().getColumnNameOnly();
			} else {
				this.name = parameterObject.getParameterName().toString();
			}

			this.procedure = procedure;
			this.mode = this.parameterObject.getParameterMode();
			this.dataType = this.parameterObject.getDataType();
			procedure.addArgument(this);
		} else {
			throw new IllegalArgumentException("Procedure Argument arguments can't be null.");
		}
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Pair3<Long, Long, String> getStartPosition() {
		return this.startPosition;
	}

	public Pair3<Long, Long, String> getEndPosition() {
		return this.endPosition;
	}

	public Procedure getProcedure() {
		return this.procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStartPosition(Pair3<Long, Long, String> startPosition) {
		this.startPosition = startPosition;
	}

	public void setEndPosition(Pair3<Long, Long, String> endPosition) {
		this.endPosition = endPosition;
	}

	public TParameterDeclaration getParameterObject() {
		return this.parameterObject;
	}

	public void setParameterObject(TParameterDeclaration parameterObject) {
		this.parameterObject = parameterObject;
	}

	public EParameterMode getMode() {
		return this.mode;
	}

	public void setMode(EParameterMode mode) {
		this.mode = mode;
	}

	public TTypeName getDataType() {
		return this.dataType;
	}

	public void setDataType(TTypeName dataType) {
		this.dataType = dataType;
	}
}
