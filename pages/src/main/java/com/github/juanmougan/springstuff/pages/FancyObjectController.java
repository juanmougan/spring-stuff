package com.github.juanmougan.springstuff.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FancyObjectController {

  @Autowired
  private FancyObjectService service;

  // TODO I also need a POST to filter, with an FancyObjectFilterRequest (also paginated)
  /*
  E.g. http://localhost:8080/fancyobjects?page=1&size=2
  would return "Isabel", "Sara" (the 3rd and 4th elements)
  * */
  @GetMapping("/fancyobjects")
  public Page<FancyObject> list(final Pageable pageable) {
    final List<FancyObject> all = service.listAll();
    return paginateList(pageable, all);
  }

  private Page<FancyObject> paginateList(final Pageable pageable, final List<FancyObject> fancyObjects) {
    int start = (int) pageable.getOffset();
    int end = Math.min((start + pageable.getPageSize()), fancyObjects.size());
    // TODO And note that if we also want to give support for sorting, we need to sort the list before sub-listing it.
    return new PageImpl<>(fancyObjects.subList(start, end), pageable, fancyObjects.size());
  }

  @PostMapping("/fancyobjects:filter")
  public Page<FancyObject> filter(final Pageable pageable, final FancyObjectFilterRequest filterRequest) {
    // TODO filter here, instead of passing the whole list
    final List<FancyObject> all = service.listAll();
    return paginateList(pageable, all);
  }
}
