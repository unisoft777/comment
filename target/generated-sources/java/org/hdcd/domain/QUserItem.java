package org.hdcd.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserItem is a Querydsl query type for UserItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserItem extends EntityPathBase<UserItem> {

    private static final long serialVersionUID = 1407864513L;

    public static final QUserItem userItem = new QUserItem("userItem");

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updDate = createDateTime("updDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> userItemNo = createNumber("userItemNo", Long.class);

    public final NumberPath<Long> userNo = createNumber("userNo", Long.class);

    public QUserItem(String variable) {
        super(UserItem.class, forVariable(variable));
    }

    public QUserItem(Path<? extends UserItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserItem(PathMetadata metadata) {
        super(UserItem.class, metadata);
    }

}

