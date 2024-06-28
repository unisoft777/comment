package org.hdcd.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QChargeCoin is a Querydsl query type for ChargeCoin
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChargeCoin extends EntityPathBase<ChargeCoin> {

    private static final long serialVersionUID = 155244520L;

    public static final QChargeCoin chargeCoin = new QChargeCoin("chargeCoin");

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final NumberPath<Long> historyNo = createNumber("historyNo", Long.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updDate = createDateTime("updDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> userNo = createNumber("userNo", Long.class);

    public QChargeCoin(String variable) {
        super(ChargeCoin.class, forVariable(variable));
    }

    public QChargeCoin(Path<? extends ChargeCoin> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChargeCoin(PathMetadata metadata) {
        super(ChargeCoin.class, metadata);
    }

}

