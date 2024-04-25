package  ma.zs.stocky.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.stock.Magasin;
import ma.zs.stocky.dao.criteria.core.stock.MagasinCriteria;
import ma.zs.stocky.service.facade.admin.stock.MagasinAdminService;
import ma.zs.stocky.ws.converter.stock.MagasinConverter;
import ma.zs.stocky.ws.dto.stock.MagasinDto;
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
@RequestMapping("/api/admin/magasin/")
public class MagasinRestAdmin  extends AbstractController<Magasin, MagasinDto, MagasinCriteria, MagasinAdminService, MagasinConverter> {



    @Operation(summary = "upload one magasin")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple magasins")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all magasins")
    @GetMapping("")
    public ResponseEntity<List<MagasinDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  magasin")
    @PostMapping("")
    public ResponseEntity<MagasinDto> save(@RequestBody MagasinDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  magasin")
    @PutMapping("")
    public ResponseEntity<MagasinDto> update(@RequestBody MagasinDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of magasin")
    @PostMapping("multiple")
    public ResponseEntity<List<MagasinDto>> delete(@RequestBody List<MagasinDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified magasin")
    @DeleteMapping("")
    public ResponseEntity<MagasinDto> delete(@RequestBody MagasinDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified magasin")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple magasins by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a magasin and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<MagasinDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds magasins by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<MagasinDto>> findByCriteria(@RequestBody MagasinCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated magasins by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody MagasinCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports magasins by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody MagasinCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets magasin data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody MagasinCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public MagasinRestAdmin (MagasinAdminService service, MagasinConverter converter) {
        super(service, converter);
    }




}
