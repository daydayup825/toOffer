package niuke;

/**
 * @author: fanbopeng
 * @Date: 2019/3/11 19:06
 * @Description:
 */
public class TrieClass {

    public static  class TrieNode{

        private int path;
        private int end;

        private TrieNode[] nexts;

        public TrieNode() {
          path=0;
          end=0;
          nexts=new TrieNode[26];
        }

    }

    public static class Trie{
        private TrieNode root;

        public Trie() {
            this.root =new TrieNode();
        }


    public void insert(String word){

        if (word==null){

            return;
        }
        char[] chs = word.toCharArray();
        TrieNode node =root;

        int index=0;
        for (int i = 0; i <chs.length ; i++) {
            index=chs[i]-'a';
            if (node.nexts[index]==null){
                node.nexts[index]=new TrieNode();

            }
           node= node.nexts[index];
            node.path++;

            }
            node.end++;

    }




    public int search(String word){

        if (word==null){

            return 0;
        }
        char[] chs = word.toCharArray();
        TrieNode node=root;
        int index=0;
        for (int i = 0; i <chs.length ; i++) {
            index=chs[i]-'a';
            if (node.nexts[index]==null){

                return 0;
            }
            node=node.nexts[index];

        }

        return node.end;
    }


    public void delete(String word){
        if (search(word)!=0){
            char[] chs = word.toCharArray();
            TrieNode node=root;
            int index=0;
            for (int i = 0; i <chs.length ; i++) {
                index=chs[i]-'a';
                if (--node.nexts[index].path==0){

                    node.nexts[index]=null;
                    return;
                }
                node=node.nexts[index];
            }
            node.end--;


        }

    }

    public int prefixNumber(String pre){
            if (pre==null){
                return 0;
            }
        char[] chs = pre.toCharArray();
            TrieNode node =root;
            int index=0;
        for (int i = 0; i <chs.length ; i++) {
            index=chs[i]-'a';
            if (node.nexts[index]==null){

                return 0;
            }
            node=node.nexts[index];




        }
        return node.path;


    }



    }

}
