package com.nlehman.vuetailwind.services;

import java.util.ArrayList;
import java.util.List;

import com.nlehman.vuetailwind.models.Product;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("alternative")
public class AlternativeProductService implements ProductService{

	public Object getProducts() {
        List<Product> products = new ArrayList<Product>();
        Product ace = new Product("Ace");
        Product acoustic = new Product("Acoustic");
        Product analog = new Product("Analog");
        Product wcAbstract = new Product("Abstract");
        Product alleyCat = new Product("Alley Cat");
        Product acousticord = new Product("Acousticord");
        Product aloft = new Product("Aloft");
        Product blitz = new Product("Blitz");
        Product fortuny = new Product("Fortuny");
        ace.setImage("fabrics/kace-hot.jpg");
        acoustic.setImage("fabrics/kacoustic-ardent.jpg");
        analog.setImage("fabrics/kanalog-grapefruit.jpg");
        wcAbstract.setImage("fabrics/kabstract-antique_silver.jpg");
        alleyCat.setImage("fabrics/kalley_cat-stone_wash.jpg");
        acousticord.setImage("fabrics/kacousticord-heather.jpg");
        aloft.setImage("fabrics/kaloft-plains.jpg");
        blitz.setImage("fabrics/kblitz-prisma.jpg");
        fortuny.setImage("fabrics/kfortuny-arundel.jpg");
        wcAbstract.setCategory(Product.WALLCOVERING);
        alleyCat.setCategory(Product.WALLCOVERING);
        acousticord.setCategory(Product.WALLCOVERING);
        aloft.setCategory(Product.PRIVACY_CURTAIN);
        blitz.setCategory(Product.PRIVACY_CURTAIN);
        fortuny.setCategory(Product.PRIVACY_CURTAIN);
        products.add(ace);
        products.add(acoustic);
        products.add(analog);
        // products.add(wcAbstract);
        // products.add(alleyCat);
        // products.add(acousticord);
        // products.add(aloft);
        // products.add(blitz);
        // products.add(fortuny);
		return products;
	}

    @Override
    public Object getProduct(long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
