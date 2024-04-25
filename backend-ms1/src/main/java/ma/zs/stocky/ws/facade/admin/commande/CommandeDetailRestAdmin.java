package  ma.zs.stocky.ws.facade.admin.commande;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.commande.CommandeDetail;
import ma.zs.stocky.dao.criteria.core.commande.CommandeDetailCriteria;
import ma.zs.stocky.service.facade.admin.commande.CommandeDetailAdminService;
import ma.zs.stocky.ws.converter.commande.CommandeDetailConverter;
import ma.zs.stocky.ws.dto.commande.CommandeDetailDto;
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
@RequestMapping("/api/admin/commandeDetail/")
public class CommandeDetailRestAdmin  extends AbstractController<CommandeDetail, CommandeDetailDto, CommandeDetailCriteria, CommandeDetailAdminService, CommandeDetailConverter> {



    @Operation(summary = "upload one commandeDetail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple commandeDetails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all commandeDetails")
    @GetMapping("")
    public ResponseEntity<List<CommandeDetailDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  commandeDetail")
    @PostMapping("")
    public ResponseEntity<CommandeDetailDto> save(@RequestBody CommandeDetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  commandeDetail")
    @PutMapping("")
    public ResponseEntity<CommandeDetailDto> update(@RequestBody CommandeDetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of commandeDetail")
    @PostMapping("multiple")
    public ResponseEntity<List<CommandeDetailDto>> delete(@RequestBody List<CommandeDetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified commandeDetail")
    @DeleteMapping("")
    public ResponseEntity<CommandeDetailDto> delete(@RequestBody CommandeDetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified commandeDetail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple commandeDetails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by commande id")
    @GetMapping("commande/id/{id}")
    public List<CommandeDetailDto> findByCommandeId(@PathVariable Long id){
        return findDtos(service.findByCommandeId(id));
    }
    @Operation(summary = "delete by commande id")
    @DeleteMapping("commande/id/{id}")
    public int deleteByCommandeId(@PathVariable Long id){
        return service.deleteByCommandeId(id);
    }
    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<CommandeDetailDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }

    @Operation(summary = "Finds a commandeDetail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CommandeDetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds commandeDetails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CommandeDetailDto>> findByCriteria(@RequestBody CommandeDetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated commandeDetails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CommandeDetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports commandeDetails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CommandeDetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets commandeDetail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CommandeDetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CommandeDetailRestAdmin (CommandeDetailAdminService service, CommandeDetailConverter converter) {
        super(service, converter);
    }




}
