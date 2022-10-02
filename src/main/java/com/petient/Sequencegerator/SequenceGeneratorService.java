package com.petient.Sequencegerator;



import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.petient.DataBaseSequence.DatabaseSequence;
import com.petient.entits.Patient;

import static org.springframework.data.mongodb.core.query.Criteria.where;
@Service
public class SequenceGeneratorService {


	@Autowired
    private  MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public  long generateSequence(Patient patient) {

        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(patient)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }


	
}
