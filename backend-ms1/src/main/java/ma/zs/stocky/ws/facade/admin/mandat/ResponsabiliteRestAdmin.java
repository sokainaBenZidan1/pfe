package  ma.zs.stocky.ws.facade.admin.mandat;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.mandat.Responsabilite;
import ma.zs.stocky.dao.criteria.core.mandat.ResponsabiliteCriteria;
import ma.zs.stocky.service.facade.admin.mandat.ResponsabiliteAdminService;
import ma.zs.stocky.ws.converter.mandat.ResponsabiliteConverter;
import ma.zs.stocky.ws.dto.mandat.ResponsabiliteDto;
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
@RequestMapping("/api/admin/responsabilite/")
public class ResponsabiliteRestAdmin  extends AbstractController<Responsabilite, ResponsabiliteDto, ResponsabiliteCriteria, ResponsabiliteAdminService, ResponsabiliteConverter> {



    @Operation(summary = "upload one responsabilite")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple responsabilites")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all responsabilites")
    @GetMapping("")
    public ResponseEntity<List<ResponsabiliteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all responsabilites")
    @GetMapping("optimized")
    public ResponseEntity<List<ResponsabiliteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a responsabilite by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<ResponsabiliteDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Responsabilite(libelle));
    }

    @Operation(summary = "Saves the specified  responsabilite")
    @PostMapping("")
    public ResponseEntity<ResponsabiliteDto> save(@RequestBody ResponsabiliteDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  responsabilite")
    @PutMapping("")
    public ResponseEntity<ResponsabiliteDto> update(@RequestBody ResponsabiliteDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of responsabilite")
    @PostMapping("multiple")
    public ResponseEntity<List<ResponsabiliteDto>> delete(@RequestBody List<ResponsabiliteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified responsabilite")
    @DeleteMapping("")
    public ResponseEntity<ResponsabiliteDto> delete(@RequestBody ResponsabiliteDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified responsabilite")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple responsabilites by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a responsabilite and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ResponsabiliteDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds responsabilites by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ResponsabiliteDto>> findByCriteria(@RequestBody ResponsabiliteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated responsabilites by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ResponsabiliteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports responsabilites by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ResponsabiliteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets responsabilite data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ResponsabiliteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ResponsabiliteRestAdmin (ResponsabiliteAdminService service, ResponsabiliteConverter converter) {
        super(service, converter);
    }




}
