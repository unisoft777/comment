package org.hdcd.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPdsFile is a Querydsl query type for PdsFile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPdsFile extends EntityPathBase<PdsFile> {

    private static final long serialVersionUID = -1346208392L;

    public static final QPdsFile pdsFile = new QPdsFile("pdsFile");

    public final NumberPath<Integer> downCnt = createNumber("downCnt", Integer.class);

    public final StringPath fullName = createString("fullName");

    public final NumberPath<Long> pdsFileId = createNumber("pdsFileId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updDate = createDateTime("updDate", java.time.LocalDateTime.class);

    public QPdsFile(String variable) {
        super(PdsFile.class, forVariable(variable));
    }

    public QPdsFile(Path<? extends PdsFile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPdsFile(PathMetadata metadata) {
        super(PdsFile.class, metadata);
    }

}

