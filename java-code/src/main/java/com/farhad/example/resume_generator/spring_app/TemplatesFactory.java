package com.farhad.example.resume_generator.spring_app;

import java.util.Map;

import com.farhad.example.resume_generator.step6.BasicResumeDataAggregator;
import com.farhad.example.resume_generator.step6.DataAggregator;
import com.farhad.example.resume_generator.step6.LongResumeDataAggregator;
import com.farhad.example.resume_generator.step6.TemplateProcess;
import com.farhad.example.resume_generator.step6.TemplateRender;

// @Configuration
public class TemplatesFactory {
//   @Bean
  public DataAggregator basicResume() {
    return new BasicResumeDataAggregator();
  }

//   @Bean
  public DataAggregator longResume() {
    return new LongResumeDataAggregator();
  }

  //@Bean
  public TemplateRender templateRender() {
    return new BasicTemplateRender();
  }

//   @Bean
  public TemplateProcess resumeTemplateProcess(
          TemplateRender templateRender,
          Map<String, DataAggregator> dataAggregators) {
    return new TemplateProcess(templateRender,
            dataAggregators);
  }
	
}
