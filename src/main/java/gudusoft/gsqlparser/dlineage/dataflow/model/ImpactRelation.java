
package gudusoft.gsqlparser.dlineage.dataflow.model;

public class ImpactRelation extends AbstractRelation {

    @Override
    public RelationType getRelationType() {
        return RelationType.fdr;
    }
}
