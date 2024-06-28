package org.hdcd.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPayCoin is a Querydsl query type for PayCoin
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPayCoin extends EntityPathBase<PayCoin> {

    private static final long serialVersionUID = -1426638410L;

    public static final QPayCoin payCoin = new QPayCoin("payCoin");

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final NumberPath<Long> historyNo = createNumber("historyNo", Long.class);

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updDate = createDateTime("updDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> userNo = createNumber("userNo", Long.class);

    public QPayCoin(String variable) {
        super(PayCoin.class, forVariable(variable));
    }

    public QPayCoin(Path<? extends PayCoin> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPayCoin(PathMetadata metadata) {
        super(PayCoin.class, metadata);
    }

}

