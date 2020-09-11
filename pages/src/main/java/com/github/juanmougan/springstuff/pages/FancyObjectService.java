package com.github.juanmougan.springstuff.pages;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FancyObjectService implements InitializingBean {

  private List<FancyObject> fancyObjects;

  private static final int PAGE_SIZE = 20;
  private static final int PAGES_WANTED = 3;
  private static final int ELEMENTS_TO_COMPLETE_LAST_PAGE = 3;

  public List<FancyObject> listAll() {
    return fancyObjects;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    final ImmutableList.Builder<FancyObject> fancyObjectBuilder = new ImmutableList.Builder<>();
    for (int i = 0; i < PAGE_SIZE * PAGES_WANTED - ELEMENTS_TO_COMPLETE_LAST_PAGE; i++) {
      fancyObjectBuilder.add(
          new FancyObject(NamesGenerator.getName(i), LocalDateTime.now().minus(Duration.ofSeconds(i)))
      );
    }
    fancyObjects = fancyObjectBuilder.build();
  }
}
