package com.hyune.raider50g.domain.booking;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRaidInfo is a Querydsl query type for RaidInfo
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QRaidInfo extends BeanPath<RaidInfo> {

    private static final long serialVersionUID = 157324318L;

    public static final QRaidInfo raidInfo = new QRaidInfo("raidInfo");

    public final BooleanPath cancel = createBoolean("cancel");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final EnumPath<com.hyune.raider50g.common.type.DungeonType> dungeonType = createEnum("dungeonType", com.hyune.raider50g.common.type.DungeonType.class);

    public final DatePath<java.time.LocalDate> raidDate = createDate("raidDate", java.time.LocalDate.class);

    public QRaidInfo(String variable) {
        super(RaidInfo.class, forVariable(variable));
    }

    public QRaidInfo(Path<? extends RaidInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRaidInfo(PathMetadata metadata) {
        super(RaidInfo.class, metadata);
    }

}

