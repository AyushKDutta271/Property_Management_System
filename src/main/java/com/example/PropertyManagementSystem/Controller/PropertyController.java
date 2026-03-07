package com.example.PropertyManagementSystem.Controller;

import com.example.PropertyManagementSystem.Dto.*;


import com.example.PropertyManagementSystem.STATUS;
import com.example.PropertyManagementSystem.Service.ConsumerLoginService;
import com.example.PropertyManagementSystem.Service.PropertyService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class PropertyController {

    @Autowired
    private PropertyService service;

    @Autowired
    private ConsumerLoginService consLoginService;

    @Value("${spring.jpa.properties.hibernate.dialect:}")
    String dbConfigDetails;


    @GetMapping("/listAllConsumers/{category}")
    public ResponseEntity<List<ConsumersDto>> listAllConsumersByCategory(@PathVariable String category)
    {
        System.out.println(dbConfigDetails);
       List<ConsumersDto> consumers= service.getAllConsumersByCategory(category);
       return ResponseEntity.status(HttpStatus.OK).body(consumers);
    }

    @GetMapping("/listAllPropertiesByCustomerId/{CustomerId}")
    public ResponseEntity<List<PropertyDto>> listAllPropertiesByCustomerId(@PathVariable Long CustomerId)
    {
        List<PropertyDto> properties= service.getAllPropertiesByCustomerId(CustomerId);
        return ResponseEntity.status(HttpStatus.OK).body(properties);
    }

    @GetMapping("/listAllProperties")
    public ResponseEntity<List<PropertyDto>> listAllProperties()
    {
        List<PropertyDto> list= service.getAllProperties();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/SearchPropertyByPropertyId/{PropertyId}")
    public ResponseEntity<PropertyDto> SearchPropertyByPropertyId(@PathVariable Long PropertyId)
    {
        PropertyDto properties= service.getPropertyByPropertyId(PropertyId);
        return ResponseEntity.status(HttpStatus.OK).body(properties);
    }

    @Operation(description="adding consumer")
    @PostMapping("/addConsumer")
    public ResponseEntity<ConsumersDto> addConsumer(
            @Parameter(
                    description = "the fields inside this belongs to ConsumersDto"
            )
            @Valid @RequestBody ConsumersDetailsDto consumer)
    {
       ConsumersDto result= service.createConsumer(consumer);
       return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(description = "adding property for sale")
    @PostMapping("/addPropertyForSell")
    public ResponseEntity<PropertyDto> addPropertyForSell(
            @Parameter(
                    description = "the data passed in this belongs to PropertyDto"
            )
            @Valid @RequestBody PropertyDetailsDto property)
    {
        PropertyDto result=  service.postProperty(property);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(description = "for updating any field in a property")
    @PatchMapping("/updateFieldInPropertyByPropertyId")
    public ResponseEntity<PropertyDto> updateFieldInPropertyByPropertyId(
            @Parameter(
                    description="data passed in this belongs to Property Dto"
            )
            @RequestParam Long PropertyId,@Valid @RequestBody Map<String,Object> field)
    {
        PropertyDto property=service.updatePropertyFieldByPropertyId(PropertyId,field);
        return ResponseEntity.status(HttpStatus.CREATED).body(property);
    }


    @GetMapping("/getPropertiesByStatus")
    public ResponseEntity<List<PropertyDto>> getPropertiesByStatus(@RequestParam String status)
    {
        List<PropertyDto> properties  = service.listPropertiesWithStatus(STATUS.valueOf(status));
        return ResponseEntity.status(HttpStatus.OK).body(properties);
    }

    @Operation(description="modifying entire property")
    @PutMapping("/updateCompletePropertyByPropertyId/{PropertyId}")
    public ResponseEntity<PropertyDto> updateCompletePropertyByPropertyId(
            @Parameter(
                    description = "Data passed in thisn belongs to PropertyDto type"
            )
            @PathVariable Long PropertyId,@Valid @RequestBody PropertyDetailsDto property)
    {
       PropertyDto result= service.updatePropertyByPropertyId(PropertyId, property);
       return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/removePropertyFromSite/{PropertyId}")
    public ResponseEntity<Void> removePropertyFromSite(@PathVariable Long PropertyId)
    {
        service.removeProperty(PropertyId);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "for user login")
    @PostMapping("/consumerLogin")
    public ResponseEntity<ConsumersDto> consumerLogin(
            @Parameter(description = "data passed here is of ConsumersDto type")
            @Valid @RequestBody ConsumerLoginDto body) throws Exception
    {
           ConsumersDto consumer= consLoginService.consumerLogin(body.getEmailId(),body.getPassword());
           return ResponseEntity.ok(consumer);
    }
}
