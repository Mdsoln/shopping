package onlineshopping.contoller;

import lombok.RequiredArgsConstructor;
import onlineshopping.entity.Item;
import onlineshopping.exc.SearchExceptions;
import onlineshopping.model.ItemResponse;
import onlineshopping.service.impl.SearchServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping(path = "/api/v1/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchServiceImpl searchService;

    // auto-completion drop-down bypassing query parameter
    @CrossOrigin()
    @GetMapping("/item-options")
    public ResponseEntity<List<String>> itemProducts(@RequestParam String queryStr){
        List<String> itemOptions = searchService.findItemNames(queryStr);
        if (itemOptions != null) {
            return ResponseEntity.ok(itemOptions);
        }else {
            throw new SearchExceptions("No option matches");
        }
    }


    // querying all items without passing any parameter, just automatically after the system loaded
    @CrossOrigin()
    @GetMapping("/items")
    public ResponseEntity<List<Item>> findAllItems(){
        List<Item> items = searchService.findFoundItems();
        return ResponseEntity.ok(items);
    }

    //querying specific item, with passed item number as a parameter
    @CrossOrigin()
    @GetMapping("/item-product")
    public ResponseEntity<ItemResponse> findItem(@RequestParam String queryStr){
        Item queryItem = searchService.findUniqueItem(queryStr);
            if (queryItem != null){
                ItemResponse itemResponse = ItemResponse.builder()
                        .itemNo(queryItem.getItemNo())
                        .itemName(queryItem.getItemName())
                        .actualPrice(queryItem.getActualPrice())
                        .discountPrice(queryItem.getDiscountPrice())
                        .quantity(queryItem.getInitialQuantity())
                        .description(queryItem.getDescription())
                        .ratings(queryItem.getRatings())
                        .imageUrl(queryItem.getImageUrl())
                        .sizes(queryItem.getSizes())
                        .colors(queryItem.getColors())
                        .categories(queryItem.getCategory())
                        .type(queryItem.getType())
                        .build();
                return ResponseEntity.ok(itemResponse);
            }else {
                throw new SearchExceptions("No item found matching your search query.");
            }
    }

    //querying image by passing image name
    @CrossOrigin()
    @GetMapping("/image/{imageName}")
    public ResponseEntity<String> getImage(@PathVariable String imageName){
        return searchService.getImagePath(imageName);
    }
}

