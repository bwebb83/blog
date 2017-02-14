package com.codeup.repositories;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Brian on 2/9/17.
 */
@Repository
public interface Posts extends CrudRepository<Post,Long> {

}
