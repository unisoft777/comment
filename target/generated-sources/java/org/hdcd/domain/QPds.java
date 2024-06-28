package org.hdcd.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPds is a Querydsl query type for Pds
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPds extends EntityPathBase<Pds> {

    private static final long serialVersionUID = 589128156L;

    public static final QPds pds = new QPds("pds");

    public final StringPath description = createString("description");

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    public final StringPath itemName = createString("itemName");

    public final ListPath<PdsFile, QPdsFile> pdsFiles = this.<PdsFile, QPdsFile>createList("pdsFiles", PdsFile.class, QPdsFile.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updDate = createDateTime("updDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> viewCnt = createNumber("viewCnt", Integer.class);

    public QPds(String variable) {
        super(Pds.class, forVariable(variable));
    }

    public QPds(Path<? extends Pds> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPds(PathMetadata metadata) {
        super(Pds.class, metadata);
    }

}

