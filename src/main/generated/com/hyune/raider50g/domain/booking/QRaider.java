package com.hyune.raider50g.domain.booking;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRaider is a Querydsl query type for Raider
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QRaider extends BeanPath<Raider> {

    private static final long serialVersionUID = -48997379L;

    public static final QRaider raider = new QRaider("raider");

    public final EnumPath<com.hyune.raider50g.domain.booking.type.ClassType> classType = createEnum("classType", com.hyune.raider50g.domain.booking.type.ClassType.class);

    public final StringPath raiderId = createString("raiderId");

    public QRaider(String variable) {
        super(Raider.class, forVariable(variable));
    }

    public QRaider(Path<? extends Raider> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRaider(PathMetadata metadata) {
        super(Raider.class, metadata);
    }

}

