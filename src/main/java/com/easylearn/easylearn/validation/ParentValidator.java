package com.easylearn.easylearn.validation;

import com.easylearn.easylearn.entity.Parent;
import com.easylearn.easylearn.repository.ParentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ParentValidator extends BaseValidator<Parent>{
    private ParentRepository parentRepository;

    @Autowired
    public ParentValidator(ParentRepository parentRepository)
    {
        super(Parent.class);
        this.parentRepository = parentRepository;
    }
}
