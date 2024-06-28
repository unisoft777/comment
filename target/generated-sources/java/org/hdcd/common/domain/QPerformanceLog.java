package org.hdcd.common.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPerformanceLog is a Querydsl query type for PerformanceLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPerformanceLog extends EntityPathBase<PerformanceLog> {

    private static final long serialVersionUID = 382078242L;

    public static final QPerformanceLog performanceLog = new QPerformanceLog("performanceLog");

    public final NumberPath<Long> durationTime = createNumber("durationTime", Long.class);

    public final NumberPath<Long> logNo = createNumber("logNo", Long.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final StringPath signatureName = createString("signatureName");

    public final StringPath signatureTypeName = createString("signatureTypeName");

    public final DateTimePath<java.time.LocalDateTime> updDate = createDateTime("updDate", java.time.LocalDateTime.class);

    public QPerformanceLog(String variable) {
        super(PerformanceLog.class, forVariable(variable));
    }

    public QPerformanceLog(Path<? extends PerformanceLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerformanceLog(PathMetadata metadata) {
        super(PerformanceLog.class, metadata);
    }

}

