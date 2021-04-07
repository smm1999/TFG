package fpm.fpg;


import fpm.AbstractAssocRuleMiner;
import fpm.data.ItemSet;
import fpm.data.ItemSets;

import java.util.List;


/**
 * Created by xschen on 8/2/2015.
 */
public class FPGrowth extends AbstractAssocRuleMiner {

   private FPTree fpTree;

   @Override
   public ItemSets minePatterns(Iterable<? extends List<String>> database, List<String> uniqueItems)
   {
      fpTree = new FPTree();
      fpTree.constructTree(database, getMinSupportLevel());
      List<ItemSet> result = fpTree.mineTree(getMinSupportLevel());
      return new ItemSets().addAll(result);
   }

   public FPTree tree(){
      return fpTree;
   }


}
