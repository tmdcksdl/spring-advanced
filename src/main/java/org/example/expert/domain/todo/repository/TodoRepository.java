package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    /**
     * todos를 조회할 때 users만 함께 조회되면 되기 때문에 간단한 연관관계이다.
     * 간단한 연관관계는 @EntityGraph를 이용하여 해결할 수 있다. 선언으로 쉽게 해결할 수 있다.
     * Pageable 객체와 함께 안정적으로 작동할 수 있는 것은 @EntityGraph 이다.
     * Fetch Join을 Pageable 객체와 함께 사용할 경우 JPA에서 페이징 쿼리와 충돌이 발생할 수 있다.
     */
    @EntityGraph(attributePaths = {"users"})
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);

    // 사용하지 않는데 왜 있는걸까...?
    int countById(Long todoId);
}
