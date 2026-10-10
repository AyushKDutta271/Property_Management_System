package com.springbootproject.PropertyManagementSystem.Controllers;

import com.springbootproject.PropertyManagementSystem.DTO.PropertyDto;

import com.springbootproject.PropertyManagementSystem.Entities.Category;
import com.springbootproject.PropertyManagementSystem.Services.PropertyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/getProperties")
    public ResponseEntity<Page<PropertyDto>> listAllProps(@PageableDefault(size = 10)Pageable pageable)
    {
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getAllProperties(pageable));
    }

    @PostMapping("/addProperty/{sellerId}")
    public ResponseEntity<PropertyDto> postProperty(@RequestBody @Valid PropertyDto prop,@PathVariable Long sellerId)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.saveAsProperty(prop,sellerId));
    }

    @GetMapping("/getPropsByCategory")
    public ResponseEntity<Page<PropertyDto>> getPropertiesByCategory(@RequestParam Category category,@PageableDefault(size = 10,sort = "category") Pageable pageable)
    {
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.propertiesByCategory(category,pageable));
    }

    @GetMapping("/getPropsBySellerId/{sellerId}")
    public ResponseEntity<Page<PropertyDto>> getPropertiesBySellerId(@PathVariable Long sellerId,@PageableDefault(value = 10) Pageable pageable)
    {
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.propertiesBySellerId(sellerId,pageable));
    }

    @PutMapping("/changeProperty/{id}")
    public ResponseEntity<PropertyDto> updateProperty(@RequestBody @Valid PropertyDto prop,@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.replaceProperty(prop,id));
    }


}
