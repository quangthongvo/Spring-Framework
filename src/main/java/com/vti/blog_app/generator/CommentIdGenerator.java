package com.vti.blog_app.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CommentIdGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object comment)
    {
        // DTNxxxx
        var hql = "SELECT COUNT(*) FROM Comment";
        long count = session
                .createSelectionQuery(hql, Long.class)
                .uniqueResult();
        return String.format("DTN%05d", count + 1);
    }
}
