package  ma.zs.stocky.ws.facade.admin.achat;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.achat.TypeAchatMateriel;
import ma.zs.stocky.dao.criteria.core.achat.TypeAchatMaterielCriteria;
import ma.zs.stocky.service.facade.admin.achat.TypeAchatMaterielAdminService;
import ma.zs.stocky.ws.converter.achat.TypeAchatMaterielConverter;
import ma.zs.stocky.ws.dto.achat.TypeAchatMaterielDto;
import ma.zs.stocky.zynerator.controller.AbstractController;
import ma.zs.stocky.zynerator.dto.AuditEntityDto;
import ma.zs.stocky.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.stocky.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.stocky.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/typeAchatMateriel/")
public class TypeAchatMaterielRestAdmin  extends AbstractController<TypeAchatMateriel, TypeAchatMaterielDto, TypeAchatMaterielCriteria, TypeAchatMaterielAdminService, TypeAchatMaterielConverter> {



    @Operation(summary = "upload one typeAchatMateriel")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple typeAchatMateriels")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all typeAchatMateriels")
    @GetMapping("")
    public ResponseEntity<List<TypeAchatMaterielDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all typeAchatMateriels")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeAchatMaterielDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a typeAchatMateriel by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TypeAchatMaterielDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new TypeAchatMateriel(libelle));
    }

    @Operation(summary = "Saves the specified  typeAchatMateriel")
    @PostMapping("")
    public ResponseEntity<TypeAchatMaterielDto> save(@RequestBody TypeAchatMaterielDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  typeAchatMateriel")
    @PutMapping("")
    public ResponseEntity<TypeAchatMaterielDto> update(@RequestBody TypeAchatMaterielDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of typeAchatMateriel")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeAchatMaterielDto>> delete(@RequestBody List<TypeAchatMaterielDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified typeAchatMateriel")
    @DeleteMapping("")
    public ResponseEntity<TypeAchatMaterielDto> delete(@RequestBody TypeAchatMaterielDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified typeAchatMateriel")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple typeAchatMateriels by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a typeAchatMateriel and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeAchatMaterielDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds typeAchatMateriels by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeAchatMaterielDto>> findByCriteria(@RequestBody TypeAchatMaterielCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated typeAchatMateriels by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeAchatMaterielCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports typeAchatMateriels by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeAchatMaterielCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets typeAchatMateriel data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeAchatMaterielCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TypeAchatMaterielRestAdmin (TypeAchatMaterielAdminService service, TypeAchatMaterielConverter converter) {
        super(service, converter);
    }




}
