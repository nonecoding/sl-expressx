package org.example.slexpresssdn.entity.node;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.example.slexpresssdn.enums.OrganTypeEnum;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * 网点实体
 */
@Node("AGENCY")
@Data
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class AgencyEntity extends BaseEntity {

    @Override
    public OrganTypeEnum getAgencyType() {
        return OrganTypeEnum.AGENCY;
    }
}
