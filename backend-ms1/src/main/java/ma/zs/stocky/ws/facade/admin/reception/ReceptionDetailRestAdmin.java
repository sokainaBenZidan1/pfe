package  ma.zs.stocky.ws.facade.admin.reception;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.reception.ReceptionDetail;
import ma.zs.stocky.dao.criteria.core.reception.ReceptionDetailCriteria;
import ma.zs.stocky.service.facade.admin.reception.ReceptionDetailAdminService;
import ma.zs.stocky.ws.converter.reception.ReceptionDetailConverter;
import ma.zs.stocky.ws.dto.reception.ReceptionDetailDto;
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
@RequestMapping("/api/admin/receptionDetail/")
public class ReceptionDetailRestAdmin  extends AbstractController<ReceptionDetail, ReceptionDetailDto, ReceptionDetailCriteria, ReceptionDetailAdminService, ReceptionDetailConverter> {



    @Operation(summary = "upload one receptionDetail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple receptionDetails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all receptionDetails")
    @GetMapping("")
    public ResponseEntity<List<ReceptionDetailDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  receptionDetail")
    @PostMapping("")
    public ResponseEntity<ReceptionDetailDto> save(@RequestBody ReceptionDetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  receptionDetail")
    @PutMapping("")
    public ResponseEntity<ReceptionDetailDto> update(@RequestBody ReceptionDetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of receptionDetail")
    @PostMapping("multiple")
    public ResponseEntity<List<ReceptionDetailDto>> delete(@RequestBody List<ReceptionDetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified receptionDetail")
    @DeleteMapping("")
    public ResponseEntity<ReceptionDetailDto> delete(@RequestBody ReceptionDetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified receptionDetail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple receptionDetails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by magasin id")
    @GetMapping("magasin/id/{id}")
    public List<ReceptionDetailDto> findByMagasinId(@PathVariable Long id){
        return findDtos(service.findByMagasinId(id));
    }
    @Operation(summary = "delete by magasin id")
    @DeleteMapping("magasin/id/{id}")
    public int deleteByMagasinId(@PathVariable Long id){
        return service.deleteByMagasinId(id);
    }
    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<ReceptionDetailDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by reception id")
    @GetMapping("reception/id/{id}")
    public List<ReceptionDetailDto> findByReceptionId(@PathVariable Long id){
        return findDtos(service.findByReceptionId(id));
    }
    @Operation(summary = "delete by reception id")
    @DeleteMapping("reception/id/{id}")
    public int deleteByReceptionId(@PathVariable Long id){
        return service.deleteByReceptionId(id);
    }

    @Operation(summary = "Finds a receptionDetail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReceptionDetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds receptionDetails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReceptionDetailDto>> findByCriteria(@RequestBody ReceptionDetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated receptionDetails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReceptionDetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports receptionDetails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReceptionDetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets receptionDetail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReceptionDetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ReceptionDetailRestAdmin (ReceptionDetailAdminService service, ReceptionDetailConverter converter) {
        super(service, converter);
    }




}
