package com.epam.springshop.api;

import com.epam.springshop.controller.model.UserModel;
import com.epam.springshop.dto.CategoryDto;
import com.epam.springshop.dto.UserDto;
import com.epam.springshop.dto.group.OnCreate;
import com.epam.springshop.dto.group.OnUpdate;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Api(tags = "Category management API")
@RequestMapping("/admin")
public interface CategoryApi {
    @ApiImplicitParams({@ApiImplicitParam(name = "categoryDto", paramType = "body", required = true, value = "CategoryDto object", dataTypeClass = CategoryDto.class)})
    @ApiOperation("Create category")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/category")
    CategoryDto createCategory(@RequestBody @Validated(OnCreate.class) CategoryDto categoryDto);

    @ApiImplicitParams({@ApiImplicitParam(name = "categoryId", paramType = "path", required = true, value = "Category id", dataTypeClass = Long.class)})
    @ApiOperation("Get category")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/category/{categoryId}")
    CategoryDto getCategory(@PathVariable @NotBlank long categoryId);

    //todo: pass adminId or not? @ApiImplicitParams({@ApiImplicitParam(name = "userId", paramType = "path", required = true, value = "Admin id",dataTypeClass = UserDto.class)})
    @ApiOperation("Get all categories")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/category")
    List<CategoryDto> getCategories();

    @ApiImplicitParams({@ApiImplicitParam(name = "categoryDto", paramType = "body", required = true, value = "CategoryDto fields to update", dataTypeClass = CategoryDto.class),
            @ApiImplicitParam(name = "categoryId", paramType = "path", required = true, value = "id to update", dataTypeClass = Long.class)})
    @ApiOperation("Update category")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/category/{categoryId}")
    CategoryDto updateCategory(@PathVariable @NotBlank long categoryId, @RequestBody @Validated(OnUpdate.class) CategoryDto categoryDto);



    @ApiImplicitParams({@ApiImplicitParam(name = "categoryId", paramType = "path", required = true, value = "Id to delete", dataTypeClass = Long.class)})
    @ApiOperation("Delete category")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/category/{categoryId}")
    ResponseEntity<Void> deleteCategory(@PathVariable @NotBlank long categoryId);


}
