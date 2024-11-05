package org.example.slexpresssdn.entity.node;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.example.slexpresssdn.enums.OrganTypeEnum;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * 一级转运中心实体 (OneLevelTransportEntity)
 */
@Node("OLT")
@Data
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class OLTEntity extends BaseEntity {

    @Override
    public OrganTypeEnum getAgencyType() {
        return OrganTypeEnum.OLT;
    }
}
