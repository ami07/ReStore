// $ANTLR 3.4 /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g 2012-12-24 16:43:25

package org.apache.pig.parser;

import java.util.HashSet;
import java.util.Set;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (visitor for default data type insertion).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL 
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class AliasMasker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "AND", "AS", "ASC", "BAG", "BOOLEAN", "BY", "BYTEARRAY", "CACHE", "CHARARRAY", "COGROUP", "COLON", "COMMA", "CROSS", "CUBE", "DATETIME", "DCOLON", "DEFINE", "DENSE", "DESC", "DIGIT", "DISTINCT", "DIV", "DOLLAR", "DOLLARVAR", "DOUBLE", "DOUBLENUMBER", "DOUBLE_PERIOD", "EQUAL", "EXECCOMMAND", "FALSE", "FILTER", "FLATTEN", "FLOAT", "FLOATINGPOINT", "FLOATNUMBER", "FOREACH", "FULL", "GENERATE", "GROUP", "ID", "IDENTIFIER_L", "IF", "IMPORT", "INNER", "INPUT", "INT", "INTEGER", "INTO", "IS", "JOIN", "LEFT", "LEFT_BRACKET", "LEFT_CURLY", "LEFT_PAREN", "LETTER", "LIMIT", "LOAD", "LONG", "LONGINTEGER", "MAP", "MAPREDUCE", "MINUS", "ML_COMMENT", "MULTILINE_QUOTEDSTRING", "NOT", "NUM_OP_EQ", "NUM_OP_GT", "NUM_OP_GTE", "NUM_OP_LT", "NUM_OP_LTE", "NUM_OP_NE", "ONSCHEMA", "OR", "ORDER", "OTHERWISE", "OUTER", "OUTPUT", "PARALLEL", "PARTITION", "PERCENT", "PERIOD", "PLUS", "POUND", "QMARK", "QUOTEDSTRING", "RANK", "RETURNS", "RIGHT", "RIGHT_BRACKET", "RIGHT_CURLY", "RIGHT_PAREN", "ROLLUP", "SAMPLE", "SEMI_COLON", "SHIP", "SL_COMMENT", "SPECIALCHAR", "SPLIT", "STAR", "STDERROR", "STDIN", "STDOUT", "STORE", "STREAM", "STR_OP_EQ", "STR_OP_GT", "STR_OP_GTE", "STR_OP_LT", "STR_OP_LTE", "STR_OP_MATCHES", "STR_OP_NE", "THROUGH", "TRUE", "TUPLE", "UNION", "USING", "VOID", "WS", "ANY", "BAG_TYPE", "BAG_TYPE_CAST", "BAG_VAL", "BIN_EXPR", "BOOL", "BOOL_COND", "CAST_EXPR", "COL_RANGE", "EXPR_IN_PAREN", "FIELD_DEF", "FIELD_DEF_WITHOUT_IDENTIFIER", "FOREACH_PLAN_COMPLEX", "FOREACH_PLAN_SIMPLE", "FUNC", "FUNC_EVAL", "FUNC_REF", "IDENTIFIER", "JOIN_ITEM", "KEY_VAL_PAIR", "MACRO_BODY", "MACRO_DEF", "MACRO_INLINE", "MAP_TYPE", "MAP_VAL", "NEG", "NESTED_CMD", "NESTED_CMD_ASSI", "NESTED_PROJ", "NULL", "PARAMS", "QUERY", "REALIAS", "RETURN_VAL", "SPLIT_BRANCH", "STATEMENT", "TOBAG", "TOMAP", "TOTUPLE", "TUPLE_TYPE", "TUPLE_TYPE_CAST", "TUPLE_VAL", "EVAL", "MATCHES"
    };

    public static final int EOF=-1;
    public static final int ALL=4;
    public static final int AND=5;
    public static final int AS=6;
    public static final int ASC=7;
    public static final int BAG=8;
    public static final int BOOLEAN=9;
    public static final int BY=10;
    public static final int BYTEARRAY=11;
    public static final int CACHE=12;
    public static final int CHARARRAY=13;
    public static final int COGROUP=14;
    public static final int COLON=15;
    public static final int COMMA=16;
    public static final int CROSS=17;
    public static final int CUBE=18;
    public static final int DATETIME=19;
    public static final int DCOLON=20;
    public static final int DEFINE=21;
    public static final int DENSE=22;
    public static final int DESC=23;
    public static final int DIGIT=24;
    public static final int DISTINCT=25;
    public static final int DIV=26;
    public static final int DOLLAR=27;
    public static final int DOLLARVAR=28;
    public static final int DOUBLE=29;
    public static final int DOUBLENUMBER=30;
    public static final int DOUBLE_PERIOD=31;
    public static final int EQUAL=32;
    public static final int EXECCOMMAND=33;
    public static final int FALSE=34;
    public static final int FILTER=35;
    public static final int FLATTEN=36;
    public static final int FLOAT=37;
    public static final int FLOATINGPOINT=38;
    public static final int FLOATNUMBER=39;
    public static final int FOREACH=40;
    public static final int FULL=41;
    public static final int GENERATE=42;
    public static final int GROUP=43;
    public static final int ID=44;
    public static final int IDENTIFIER_L=45;
    public static final int IF=46;
    public static final int IMPORT=47;
    public static final int INNER=48;
    public static final int INPUT=49;
    public static final int INT=50;
    public static final int INTEGER=51;
    public static final int INTO=52;
    public static final int IS=53;
    public static final int JOIN=54;
    public static final int LEFT=55;
    public static final int LEFT_BRACKET=56;
    public static final int LEFT_CURLY=57;
    public static final int LEFT_PAREN=58;
    public static final int LETTER=59;
    public static final int LIMIT=60;
    public static final int LOAD=61;
    public static final int LONG=62;
    public static final int LONGINTEGER=63;
    public static final int MAP=64;
    public static final int MAPREDUCE=65;
    public static final int MINUS=66;
    public static final int ML_COMMENT=67;
    public static final int MULTILINE_QUOTEDSTRING=68;
    public static final int NOT=69;
    public static final int NUM_OP_EQ=70;
    public static final int NUM_OP_GT=71;
    public static final int NUM_OP_GTE=72;
    public static final int NUM_OP_LT=73;
    public static final int NUM_OP_LTE=74;
    public static final int NUM_OP_NE=75;
    public static final int ONSCHEMA=76;
    public static final int OR=77;
    public static final int ORDER=78;
    public static final int OTHERWISE=79;
    public static final int OUTER=80;
    public static final int OUTPUT=81;
    public static final int PARALLEL=82;
    public static final int PARTITION=83;
    public static final int PERCENT=84;
    public static final int PERIOD=85;
    public static final int PLUS=86;
    public static final int POUND=87;
    public static final int QMARK=88;
    public static final int QUOTEDSTRING=89;
    public static final int RANK=90;
    public static final int RETURNS=91;
    public static final int RIGHT=92;
    public static final int RIGHT_BRACKET=93;
    public static final int RIGHT_CURLY=94;
    public static final int RIGHT_PAREN=95;
    public static final int ROLLUP=96;
    public static final int SAMPLE=97;
    public static final int SEMI_COLON=98;
    public static final int SHIP=99;
    public static final int SL_COMMENT=100;
    public static final int SPECIALCHAR=101;
    public static final int SPLIT=102;
    public static final int STAR=103;
    public static final int STDERROR=104;
    public static final int STDIN=105;
    public static final int STDOUT=106;
    public static final int STORE=107;
    public static final int STREAM=108;
    public static final int STR_OP_EQ=109;
    public static final int STR_OP_GT=110;
    public static final int STR_OP_GTE=111;
    public static final int STR_OP_LT=112;
    public static final int STR_OP_LTE=113;
    public static final int STR_OP_MATCHES=114;
    public static final int STR_OP_NE=115;
    public static final int THROUGH=116;
    public static final int TRUE=117;
    public static final int TUPLE=118;
    public static final int UNION=119;
    public static final int USING=120;
    public static final int VOID=121;
    public static final int WS=122;
    public static final int ANY=123;
    public static final int BAG_TYPE=124;
    public static final int BAG_TYPE_CAST=125;
    public static final int BAG_VAL=126;
    public static final int BIN_EXPR=127;
    public static final int BOOL=128;
    public static final int BOOL_COND=129;
    public static final int CAST_EXPR=130;
    public static final int COL_RANGE=131;
    public static final int EXPR_IN_PAREN=132;
    public static final int FIELD_DEF=133;
    public static final int FIELD_DEF_WITHOUT_IDENTIFIER=134;
    public static final int FOREACH_PLAN_COMPLEX=135;
    public static final int FOREACH_PLAN_SIMPLE=136;
    public static final int FUNC=137;
    public static final int FUNC_EVAL=138;
    public static final int FUNC_REF=139;
    public static final int IDENTIFIER=140;
    public static final int JOIN_ITEM=141;
    public static final int KEY_VAL_PAIR=142;
    public static final int MACRO_BODY=143;
    public static final int MACRO_DEF=144;
    public static final int MACRO_INLINE=145;
    public static final int MAP_TYPE=146;
    public static final int MAP_VAL=147;
    public static final int NEG=148;
    public static final int NESTED_CMD=149;
    public static final int NESTED_CMD_ASSI=150;
    public static final int NESTED_PROJ=151;
    public static final int NULL=152;
    public static final int PARAMS=153;
    public static final int QUERY=154;
    public static final int REALIAS=155;
    public static final int RETURN_VAL=156;
    public static final int SPLIT_BRANCH=157;
    public static final int STATEMENT=158;
    public static final int TOBAG=159;
    public static final int TOMAP=160;
    public static final int TOTUPLE=161;
    public static final int TUPLE_TYPE=162;
    public static final int TUPLE_TYPE_CAST=163;
    public static final int TUPLE_VAL=164;
    public static final int EVAL=165;
    public static final int MATCHES=166;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public AliasMasker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AliasMasker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AliasMasker.tokenNames; }
    public String getGrammarFileName() { return "/home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g"; }



    @Override
    public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    	if (e instanceof ParserValidationException) {
    		return e.toString();
    	} 
    	return super.getErrorMessage(e, tokenNames);
    }

    public void setParams(Set ps, String macro, long idx) {
        params = ps; 
        macroName = macro;
        index = idx;
    }

    private String getMask(String alias) {
        return params.contains( alias ) 
            ? alias 
            : "macro_" + macroName + "_" + alias + "_" + index;
    }

    private Set<String> params = new HashSet<String>();

    private Set<String> aliasSeen = new HashSet<String>();

    private String macroName = "";

    private long index = 0;

    private boolean inAsOrGenClause = false;



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:82:1: query : ^( QUERY ( statement )* ) ;
    public final AliasMasker.query_return query() throws RecognitionException {
        AliasMasker.query_return retval = new AliasMasker.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AliasMasker.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:82:7: ( ^( QUERY ( statement )* ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:82:9: ^( QUERY ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_query81); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUERY1_tree = (CommonTree)adaptor.dupNode(QUERY1);


            root_1 = (CommonTree)adaptor.becomeRoot(QUERY1_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:82:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:82:18: statement
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_query83);
                	    statement2=statement();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, statement2.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "query"


    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:85:1: statement : ( general_statement | split_statement | realias_statement );
    public final AliasMasker.statement_return statement() throws RecognitionException {
        AliasMasker.statement_return retval = new AliasMasker.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.general_statement_return general_statement3 =null;

        AliasMasker.split_statement_return split_statement4 =null;

        AliasMasker.realias_statement_return realias_statement5 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:85:11: ( general_statement | split_statement | realias_statement )
            int alt2=3;
            switch ( input.LA(1) ) {
            case STATEMENT:
                {
                alt2=1;
                }
                break;
            case SPLIT:
                {
                alt2=2;
                }
                break;
            case REALIAS:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:85:13: general_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_general_statement_in_statement95);
                    general_statement3=general_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, general_statement3.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:86:13: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement109);
                    split_statement4=split_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_statement4.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:87:13: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement123);
                    realias_statement5=realias_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, realias_statement5.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class split_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_statement"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:90:1: split_statement : split_clause ;
    public final AliasMasker.split_statement_return split_statement() throws RecognitionException {
        AliasMasker.split_statement_return retval = new AliasMasker.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.split_clause_return split_clause6 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:90:17: ( split_clause )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:90:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement132);
            split_clause6=split_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, split_clause6.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_statement"


    public static class realias_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_statement"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:93:1: realias_statement : realias_clause ;
    public final AliasMasker.realias_statement_return realias_statement() throws RecognitionException {
        AliasMasker.realias_statement_return retval = new AliasMasker.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.realias_clause_return realias_clause7 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:93:19: ( realias_clause )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:93:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement141);
            realias_clause7=realias_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, realias_clause7.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_statement"


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:97:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AliasMasker.general_statement_return general_statement() throws RecognitionException {
        AliasMasker.general_statement_return retval = new AliasMasker.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT8=null;
        AliasMasker.alias_return alias9 =null;

        AliasMasker.op_clause_return op_clause10 =null;

        AliasMasker.parallel_clause_return parallel_clause11 =null;


        CommonTree STATEMENT8_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:98:5: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:98:7: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT8=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement158); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT8_tree = (CommonTree)adaptor.dupNode(STATEMENT8);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT8_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:98:20: ( alias )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:98:22: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement162);
                    alias9=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias9.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement176);
            op_clause10=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause10.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:99:19: ( parallel_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PARALLEL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:99:19: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement178);
                    parallel_clause11=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause11.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "general_statement"


    public static class realias_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:102:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AliasMasker.realias_clause_return realias_clause() throws RecognitionException {
        AliasMasker.realias_clause_return retval = new AliasMasker.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS12=null;
        CommonTree IDENTIFIER14=null;
        AliasMasker.alias_return alias13 =null;


        CommonTree REALIAS12_tree=null;
        CommonTree IDENTIFIER14_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:102:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:102:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS12=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause192); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS12_tree = (CommonTree)adaptor.dupNode(REALIAS12);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS12_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause194);
            alias13=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias13.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER14=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause196); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER14_tree = (CommonTree)adaptor.dupNode(IDENTIFIER14);


            adaptor.addChild(root_1, IDENTIFIER14_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_clause"


    public static class parallel_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parallel_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:105:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AliasMasker.parallel_clause_return parallel_clause() throws RecognitionException {
        AliasMasker.parallel_clause_return retval = new AliasMasker.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL15=null;
        CommonTree INTEGER16=null;

        CommonTree PARALLEL15_tree=null;
        CommonTree INTEGER16_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:106:5: ( ^( PARALLEL INTEGER ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:106:7: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL15=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause213); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL15_tree = (CommonTree)adaptor.dupNode(PARALLEL15);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL15_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER16=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause215); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER16_tree = (CommonTree)adaptor.dupNode(INTEGER16);


            adaptor.addChild(root_1, INTEGER16_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parallel_clause"


    public static class alias_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:109:1: alias : IDENTIFIER ;
    public final AliasMasker.alias_return alias() throws RecognitionException {
        AliasMasker.alias_return retval = new AliasMasker.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER17=null;

        CommonTree IDENTIFIER17_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:110:5: ( IDENTIFIER )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:110:7: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER17=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias232); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER17_tree = (CommonTree)adaptor.dupNode(IDENTIFIER17);


            adaptor.addChild(root_0, IDENTIFIER17_tree);
            }


            if ( state.backtracking==0 ) { 
                        aliasSeen.add((IDENTIFIER17!=null?IDENTIFIER17.getText():null)); 
                        IDENTIFIER17.getToken().setText(getMask((IDENTIFIER17!=null?IDENTIFIER17.getText():null))); 
                    }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias"


    public static class op_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:117:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause );
    public final AliasMasker.op_clause_return op_clause() throws RecognitionException {
        AliasMasker.op_clause_return retval = new AliasMasker.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.define_clause_return define_clause18 =null;

        AliasMasker.load_clause_return load_clause19 =null;

        AliasMasker.group_clause_return group_clause20 =null;

        AliasMasker.store_clause_return store_clause21 =null;

        AliasMasker.filter_clause_return filter_clause22 =null;

        AliasMasker.distinct_clause_return distinct_clause23 =null;

        AliasMasker.limit_clause_return limit_clause24 =null;

        AliasMasker.sample_clause_return sample_clause25 =null;

        AliasMasker.order_clause_return order_clause26 =null;

        AliasMasker.rank_clause_return rank_clause27 =null;

        AliasMasker.cross_clause_return cross_clause28 =null;

        AliasMasker.join_clause_return join_clause29 =null;

        AliasMasker.union_clause_return union_clause30 =null;

        AliasMasker.stream_clause_return stream_clause31 =null;

        AliasMasker.mr_clause_return mr_clause32 =null;

        AliasMasker.split_clause_return split_clause33 =null;

        AliasMasker.foreach_clause_return foreach_clause34 =null;

        AliasMasker.cube_clause_return cube_clause35 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:117:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause )
            int alt5=18;
            switch ( input.LA(1) ) {
            case DEFINE:
                {
                alt5=1;
                }
                break;
            case LOAD:
                {
                alt5=2;
                }
                break;
            case COGROUP:
            case GROUP:
                {
                alt5=3;
                }
                break;
            case STORE:
                {
                alt5=4;
                }
                break;
            case FILTER:
                {
                alt5=5;
                }
                break;
            case DISTINCT:
                {
                alt5=6;
                }
                break;
            case LIMIT:
                {
                alt5=7;
                }
                break;
            case SAMPLE:
                {
                alt5=8;
                }
                break;
            case ORDER:
                {
                alt5=9;
                }
                break;
            case RANK:
                {
                alt5=10;
                }
                break;
            case CROSS:
                {
                alt5=11;
                }
                break;
            case JOIN:
                {
                alt5=12;
                }
                break;
            case UNION:
                {
                alt5=13;
                }
                break;
            case STREAM:
                {
                alt5=14;
                }
                break;
            case MAPREDUCE:
                {
                alt5=15;
                }
                break;
            case SPLIT:
                {
                alt5=16;
                }
                break;
            case FOREACH:
                {
                alt5=17;
                }
                break;
            case CUBE:
                {
                alt5=18;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:117:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause252);
                    define_clause18=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause18.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:118:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause267);
                    load_clause19=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause19.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:119:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause281);
                    group_clause20=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause20.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:120:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause295);
                    store_clause21=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause21.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:121:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause309);
                    filter_clause22=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause22.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:122:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause323);
                    distinct_clause23=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause23.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:123:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause337);
                    limit_clause24=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause24.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:124:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause351);
                    sample_clause25=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause25.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:125:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause365);
                    order_clause26=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause26.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:126:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause379);
                    rank_clause27=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause27.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:127:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause393);
                    cross_clause28=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause28.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:128:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause407);
                    join_clause29=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause29.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:129:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause421);
                    union_clause30=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause30.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:130:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause435);
                    stream_clause31=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause31.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:131:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause449);
                    mr_clause32=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause32.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:132:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause463);
                    split_clause33=split_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_clause33.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:133:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause477);
                    foreach_clause34=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause34.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:134:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause491);
                    cube_clause35=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause35.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "op_clause"


    public static class define_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "define_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:137:1: define_clause : ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) ;
    public final AliasMasker.define_clause_return define_clause() throws RecognitionException {
        AliasMasker.define_clause_return retval = new AliasMasker.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE36=null;
        CommonTree IDENTIFIER37=null;
        AliasMasker.cmd_return cmd38 =null;

        AliasMasker.func_clause_return func_clause39 =null;


        CommonTree DEFINE36_tree=null;
        CommonTree IDENTIFIER37_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:138:5: ( ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:138:7: ^( DEFINE IDENTIFIER ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE36=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause507); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE36_tree = (CommonTree)adaptor.dupNode(DEFINE36);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE36_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER37=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_define_clause509); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER37_tree = (CommonTree)adaptor.dupNode(IDENTIFIER37);


            adaptor.addChild(root_1, IDENTIFIER37_tree);
            }


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:138:29: ( cmd | func_clause )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==EXECCOMMAND) ) {
                alt6=1;
            }
            else if ( (LA6_0==FUNC||LA6_0==FUNC_REF) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:138:31: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause514);
                    cmd38=cmd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd38.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:138:37: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause518);
                    func_clause39=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause39.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "define_clause"


    public static class cmd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cmd"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:141:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AliasMasker.cmd_return cmd() throws RecognitionException {
        AliasMasker.cmd_return retval = new AliasMasker.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND40=null;
        AliasMasker.ship_clause_return ship_clause41 =null;

        AliasMasker.cache_clause_return cache_clause42 =null;

        AliasMasker.input_clause_return input_clause43 =null;

        AliasMasker.output_clause_return output_clause44 =null;

        AliasMasker.error_clause_return error_clause45 =null;


        CommonTree EXECCOMMAND40_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:142:5: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:142:7: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND40=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd538); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND40_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND40);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND40_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:143:9: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
                loop7:
                do {
                    int alt7=6;
                    switch ( input.LA(1) ) {
                    case SHIP:
                        {
                        alt7=1;
                        }
                        break;
                    case CACHE:
                        {
                        alt7=2;
                        }
                        break;
                    case INPUT:
                        {
                        alt7=3;
                        }
                        break;
                    case OUTPUT:
                        {
                        alt7=4;
                        }
                        break;
                    case STDERROR:
                        {
                        alt7=5;
                        }
                        break;

                    }

                    switch (alt7) {
                	case 1 :
                	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:143:11: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd551);
                	    ship_clause41=ship_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause41.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:143:25: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd555);
                	    cache_clause42=cache_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause42.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:143:40: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd559);
                	    input_clause43=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause43.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:143:55: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd563);
                	    output_clause44=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause44.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:143:71: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd567);
                	    error_clause45=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause45.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop7;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cmd"


    public static class ship_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ship_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:146:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AliasMasker.ship_clause_return ship_clause() throws RecognitionException {
        AliasMasker.ship_clause_return retval = new AliasMasker.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP46=null;
        AliasMasker.path_list_return path_list47 =null;


        CommonTree SHIP46_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:147:5: ( ^( SHIP ( path_list )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:147:7: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP46=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause588); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP46_tree = (CommonTree)adaptor.dupNode(SHIP46);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP46_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:147:15: ( path_list )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTEDSTRING) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:147:15: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause590);
                        path_list47=path_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list47.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ship_clause"


    public static class path_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "path_list"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:150:1: path_list : ( QUOTEDSTRING )+ ;
    public final AliasMasker.path_list_return path_list() throws RecognitionException {
        AliasMasker.path_list_return retval = new AliasMasker.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING48=null;

        CommonTree QUOTEDSTRING48_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:151:5: ( ( QUOTEDSTRING )+ )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:151:7: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:151:7: ( QUOTEDSTRING )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:151:7: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING48=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list607); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING48_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING48);


            	    adaptor.addChild(root_0, QUOTEDSTRING48_tree);
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "path_list"


    public static class cache_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cache_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:154:1: cache_clause : ^( CACHE path_list ) ;
    public final AliasMasker.cache_clause_return cache_clause() throws RecognitionException {
        AliasMasker.cache_clause_return retval = new AliasMasker.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE49=null;
        AliasMasker.path_list_return path_list50 =null;


        CommonTree CACHE49_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:155:5: ( ^( CACHE path_list ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:155:7: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE49=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause625); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE49_tree = (CommonTree)adaptor.dupNode(CACHE49);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE49_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause627);
            path_list50=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list50.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cache_clause"


    public static class input_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:158:1: input_clause : ^( INPUT ( stream_cmd )+ ) ;
    public final AliasMasker.input_clause_return input_clause() throws RecognitionException {
        AliasMasker.input_clause_return retval = new AliasMasker.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT51=null;
        AliasMasker.stream_cmd_return stream_cmd52 =null;


        CommonTree INPUT51_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:159:5: ( ^( INPUT ( stream_cmd )+ ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:159:7: ^( INPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT51=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause645); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT51_tree = (CommonTree)adaptor.dupNode(INPUT51);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT51_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:159:16: ( stream_cmd )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING||(LA10_0 >= STDIN && LA10_0 <= STDOUT)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:159:16: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause647);
            	    stream_cmd52=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd52.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "input_clause"


    public static class stream_cmd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:162:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AliasMasker.stream_cmd_return stream_cmd() throws RecognitionException {
        AliasMasker.stream_cmd_return retval = new AliasMasker.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN53=null;
        CommonTree STDOUT55=null;
        CommonTree QUOTEDSTRING57=null;
        AliasMasker.func_clause_return func_clause54 =null;

        AliasMasker.func_clause_return func_clause56 =null;

        AliasMasker.func_clause_return func_clause58 =null;


        CommonTree STDIN53_tree=null;
        CommonTree STDOUT55_tree=null;
        CommonTree QUOTEDSTRING57_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:163:5: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case STDIN:
                {
                alt14=1;
                }
                break;
            case STDOUT:
                {
                alt14=2;
                }
                break;
            case QUOTEDSTRING:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:163:7: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN53=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd666); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN53_tree = (CommonTree)adaptor.dupNode(STDIN53);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN53_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:163:16: ( func_clause )?
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==FUNC||LA11_0==FUNC_REF) ) {
                            alt11=1;
                        }
                        switch (alt11) {
                            case 1 :
                                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:163:16: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd668);
                                func_clause54=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause54.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:164:7: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT55=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd681); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT55_tree = (CommonTree)adaptor.dupNode(STDOUT55);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT55_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:164:17: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:164:17: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd683);
                                func_clause56=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause56.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:165:7: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING57=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd696); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING57_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING57);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING57_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:165:23: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:165:23: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd698);
                                func_clause58=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause58.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_cmd"


    public static class output_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "output_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:168:1: output_clause : ^( OUTPUT ( stream_cmd )+ ) ;
    public final AliasMasker.output_clause_return output_clause() throws RecognitionException {
        AliasMasker.output_clause_return retval = new AliasMasker.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT59=null;
        AliasMasker.stream_cmd_return stream_cmd60 =null;


        CommonTree OUTPUT59_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:169:5: ( ^( OUTPUT ( stream_cmd )+ ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:169:7: ^( OUTPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT59=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause717); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT59_tree = (CommonTree)adaptor.dupNode(OUTPUT59);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT59_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:169:17: ( stream_cmd )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==QUOTEDSTRING||(LA15_0 >= STDIN && LA15_0 <= STDOUT)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:169:17: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause719);
            	    stream_cmd60=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd60.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "output_clause"


    public static class error_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:172:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AliasMasker.error_clause_return error_clause() throws RecognitionException {
        AliasMasker.error_clause_return retval = new AliasMasker.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR61=null;
        CommonTree QUOTEDSTRING62=null;
        CommonTree INTEGER63=null;

        CommonTree STDERROR61_tree=null;
        CommonTree QUOTEDSTRING62_tree=null;
        CommonTree INTEGER63_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:173:5: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:173:7: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR61=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause738); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR61_tree = (CommonTree)adaptor.dupNode(STDERROR61);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR61_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:173:19: ( QUOTEDSTRING ( INTEGER )? )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUOTEDSTRING) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:173:21: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING62=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause742); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING62_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING62);


                        adaptor.addChild(root_1, QUOTEDSTRING62_tree);
                        }


                        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:173:34: ( INTEGER )?
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==INTEGER) ) {
                            alt16=1;
                        }
                        switch (alt16) {
                            case 1 :
                                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:173:34: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER63=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause744); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER63_tree = (CommonTree)adaptor.dupNode(INTEGER63);


                                adaptor.addChild(root_1, INTEGER63_tree);
                                }


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "error_clause"


    public static class load_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:176:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AliasMasker.load_clause_return load_clause() throws RecognitionException {
        AliasMasker.load_clause_return retval = new AliasMasker.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD64=null;
        AliasMasker.filename_return filename65 =null;

        AliasMasker.func_clause_return func_clause66 =null;

        AliasMasker.as_clause_return as_clause67 =null;


        CommonTree LOAD64_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:177:5: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:177:7: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD64=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause766); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD64_tree = (CommonTree)adaptor.dupNode(LOAD64);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD64_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause768);
            filename65=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename65.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:177:24: ( func_clause )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FUNC||LA18_0==FUNC_REF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:177:24: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause770);
                    func_clause66=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause66.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:177:37: ( as_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:177:37: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause773);
                    as_clause67=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause67.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "load_clause"


    public static class filename_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filename"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:180:1: filename : QUOTEDSTRING ;
    public final AliasMasker.filename_return filename() throws RecognitionException {
        AliasMasker.filename_return retval = new AliasMasker.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING68=null;

        CommonTree QUOTEDSTRING68_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:181:5: ( QUOTEDSTRING )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:181:7: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING68=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename790); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING68_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING68);


            adaptor.addChild(root_0, QUOTEDSTRING68_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filename"


    public static class as_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:184:1: as_clause : ^( AS field_def_list ) ;
    public final AliasMasker.as_clause_return as_clause() throws RecognitionException {
        AliasMasker.as_clause_return retval = new AliasMasker.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS69=null;
        AliasMasker.field_def_list_return field_def_list70 =null;


        CommonTree AS69_tree=null;

         
        	inAsOrGenClause = true;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:191:5: ( ^( AS field_def_list ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:191:7: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS69=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause816); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS69_tree = (CommonTree)adaptor.dupNode(AS69);


            root_1 = (CommonTree)adaptor.becomeRoot(AS69_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause818);
            field_def_list70=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list70.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) { 
            	inAsOrGenClause = false; 
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "as_clause"


    public static class field_def_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:194:1: field_def : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) );
    public final AliasMasker.field_def_return field_def() throws RecognitionException {
        AliasMasker.field_def_return retval = new AliasMasker.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF71=null;
        CommonTree IDENTIFIER72=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER74=null;
        AliasMasker.type_return type73 =null;

        AliasMasker.type_return type75 =null;


        CommonTree FIELD_DEF71_tree=null;
        CommonTree IDENTIFIER72_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER74_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:195:5: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==FIELD_DEF) ) {
                alt21=1;
            }
            else if ( (LA21_0==FIELD_DEF_WITHOUT_IDENTIFIER) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:195:7: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF71=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def835); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF71_tree = (CommonTree)adaptor.dupNode(FIELD_DEF71);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF71_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER72=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def837); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER72_tree = (CommonTree)adaptor.dupNode(IDENTIFIER72);


                    adaptor.addChild(root_1, IDENTIFIER72_tree);
                    }


                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:195:31: ( type )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==BOOLEAN||LA20_0==BYTEARRAY||LA20_0==CHARARRAY||LA20_0==DATETIME||LA20_0==DOUBLE||LA20_0==FLOAT||LA20_0==INT||LA20_0==LONG||LA20_0==BAG_TYPE||LA20_0==MAP_TYPE||LA20_0==TUPLE_TYPE) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:195:31: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def839);
                            type73=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type73.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    	if (inAsOrGenClause) {
                    		if (aliasSeen.contains((IDENTIFIER72!=null?IDENTIFIER72.getText():null))) {
                    			throw new ParserValidationException(input, new SourceLocation((PigParserNode)((CommonTree)retval.start)), 
                    				"Macro doesn't support user defined schema that contains name that conflicts with alias name: " + (IDENTIFIER72!=null?IDENTIFIER72.getText():null));
                    		}
                    	}
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:203:7: ^( FIELD_DEF_WITHOUT_IDENTIFIER type )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER74=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def854); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER74_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER74);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER74_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def856);
                    type75=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type75.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_def"


    public static class field_def_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:206:1: field_def_list : ( field_def )+ ;
    public final AliasMasker.field_def_list_return field_def_list() throws RecognitionException {
        AliasMasker.field_def_list_return retval = new AliasMasker.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.field_def_return field_def76 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:207:5: ( ( field_def )+ )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:207:7: ( field_def )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:207:7: ( field_def )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0 >= FIELD_DEF && LA22_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:207:7: field_def
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list871);
            	    field_def76=field_def();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def76.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:210:1: type : ( simple_type | tuple_type | bag_type | map_type );
    public final AliasMasker.type_return type() throws RecognitionException {
        AliasMasker.type_return retval = new AliasMasker.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.simple_type_return simple_type77 =null;

        AliasMasker.tuple_type_return tuple_type78 =null;

        AliasMasker.bag_type_return bag_type79 =null;

        AliasMasker.map_type_return map_type80 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:210:6: ( simple_type | tuple_type | bag_type | map_type )
            int alt23=4;
            switch ( input.LA(1) ) {
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DATETIME:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt23=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt23=2;
                }
                break;
            case BAG_TYPE:
                {
                alt23=3;
                }
                break;
            case MAP_TYPE:
                {
                alt23=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }

            switch (alt23) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:210:8: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type882);
                    simple_type77=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type77.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:210:22: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type886);
                    tuple_type78=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type78.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:210:35: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type890);
                    bag_type79=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type79.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:210:46: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type894);
                    map_type80=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type80.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"


    public static class simple_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:213:1: simple_type : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY );
    public final AliasMasker.simple_type_return simple_type() throws RecognitionException {
        AliasMasker.simple_type_return retval = new AliasMasker.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set81=null;

        CommonTree set81_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:214:5: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set81=(CommonTree)input.LT(1);

            if ( input.LA(1)==BOOLEAN||input.LA(1)==BYTEARRAY||input.LA(1)==CHARARRAY||input.LA(1)==DATETIME||input.LA(1)==DOUBLE||input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==LONG ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set81_tree = (CommonTree)adaptor.dupNode(set81);


                adaptor.addChild(root_0, set81_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simple_type"


    public static class tuple_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:217:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AliasMasker.tuple_type_return tuple_type() throws RecognitionException {
        AliasMasker.tuple_type_return retval = new AliasMasker.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE82=null;
        AliasMasker.field_def_list_return field_def_list83 =null;


        CommonTree TUPLE_TYPE82_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:218:5: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:218:7: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE82=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type953); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE82_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE82);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE82_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:218:21: ( field_def_list )?
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0 >= FIELD_DEF && LA24_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt24=1;
                }
                switch (alt24) {
                    case 1 :
                        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:218:21: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type955);
                        field_def_list83=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list83.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type"


    public static class bag_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:221:1: bag_type : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final AliasMasker.bag_type_return bag_type() throws RecognitionException {
        AliasMasker.bag_type_return retval = new AliasMasker.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE84=null;
        CommonTree IDENTIFIER85=null;
        AliasMasker.tuple_type_return tuple_type86 =null;


        CommonTree BAG_TYPE84_tree=null;
        CommonTree IDENTIFIER85_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:222:5: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:222:7: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE84=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type974); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE84_tree = (CommonTree)adaptor.dupNode(BAG_TYPE84);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE84_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:222:19: ( IDENTIFIER )?
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==IDENTIFIER) ) {
                    alt25=1;
                }
                switch (alt25) {
                    case 1 :
                        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:222:19: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER85=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type976); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER85_tree = (CommonTree)adaptor.dupNode(IDENTIFIER85);


                        adaptor.addChild(root_1, IDENTIFIER85_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:222:31: ( tuple_type )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==TUPLE_TYPE) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:222:31: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type979);
                        tuple_type86=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type86.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:225:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AliasMasker.map_type_return map_type() throws RecognitionException {
        AliasMasker.map_type_return retval = new AliasMasker.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE87=null;
        AliasMasker.type_return type88 =null;


        CommonTree MAP_TYPE87_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:225:10: ( ^( MAP_TYPE ( type )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:225:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE87=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type993); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE87_tree = (CommonTree)adaptor.dupNode(MAP_TYPE87);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE87_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:225:24: ( type )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==BOOLEAN||LA27_0==BYTEARRAY||LA27_0==CHARARRAY||LA27_0==DATETIME||LA27_0==DOUBLE||LA27_0==FLOAT||LA27_0==INT||LA27_0==LONG||LA27_0==BAG_TYPE||LA27_0==MAP_TYPE||LA27_0==TUPLE_TYPE) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:225:24: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type995);
                        type88=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type88.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_type"


    public static class func_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:228:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AliasMasker.func_clause_return func_clause() throws RecognitionException {
        AliasMasker.func_clause_return retval = new AliasMasker.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF89=null;
        CommonTree FUNC91=null;
        AliasMasker.func_name_return func_name90 =null;

        AliasMasker.func_name_return func_name92 =null;

        AliasMasker.func_args_return func_args93 =null;


        CommonTree FUNC_REF89_tree=null;
        CommonTree FUNC91_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:229:5: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==FUNC_REF) ) {
                alt29=1;
            }
            else if ( (LA29_0==FUNC) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:229:7: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF89=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1014); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF89_tree = (CommonTree)adaptor.dupNode(FUNC_REF89);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF89_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1016);
                    func_name90=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name90.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:230:7: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC91=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1028); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC91_tree = (CommonTree)adaptor.dupNode(FUNC91);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC91_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1030);
                    func_name92=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name92.getTree());


                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:230:25: ( func_args )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==QUOTEDSTRING) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:230:25: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1032);
                            func_args93=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args93.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_clause"


    public static class func_name_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_name"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:233:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AliasMasker.func_name_return func_name() throws RecognitionException {
        AliasMasker.func_name_return retval = new AliasMasker.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set95=null;
        AliasMasker.eid_return eid94 =null;

        AliasMasker.eid_return eid96 =null;


        CommonTree set95_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:234:5: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:234:7: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1049);
            eid94=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid94.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:234:11: ( ( PERIOD | DOLLAR ) eid )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==DOLLAR||LA30_0==PERIOD) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:234:13: ( PERIOD | DOLLAR ) eid
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    set95=(CommonTree)input.LT(1);

            	    if ( input.LA(1)==DOLLAR||input.LA(1)==PERIOD ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) {
            	        set95_tree = (CommonTree)adaptor.dupNode(set95);


            	        adaptor.addChild(root_0, set95_tree);
            	        }

            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1063);
            	    eid96=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid96.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_name"


    public static class func_args_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:237:1: func_args : ( QUOTEDSTRING )+ ;
    public final AliasMasker.func_args_return func_args() throws RecognitionException {
        AliasMasker.func_args_return retval = new AliasMasker.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING97=null;

        CommonTree QUOTEDSTRING97_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:238:5: ( ( QUOTEDSTRING )+ )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:238:7: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:238:7: ( QUOTEDSTRING )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==QUOTEDSTRING) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:238:7: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING97=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1080); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING97_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING97);


            	    adaptor.addChild(root_0, QUOTEDSTRING97_tree);
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_args"


    public static class cube_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:241:1: cube_clause : ^( CUBE cube_item ) ;
    public final AliasMasker.cube_clause_return cube_clause() throws RecognitionException {
        AliasMasker.cube_clause_return retval = new AliasMasker.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE98=null;
        AliasMasker.cube_item_return cube_item99 =null;


        CommonTree CUBE98_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:242:5: ( ^( CUBE cube_item ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:242:7: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE98=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1097); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE98_tree = (CommonTree)adaptor.dupNode(CUBE98);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE98_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1099);
            cube_item99=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item99.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_clause"


    public static class cube_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_item"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:245:1: cube_item : rel ( cube_by_clause ) ;
    public final AliasMasker.cube_item_return cube_item() throws RecognitionException {
        AliasMasker.cube_item_return retval = new AliasMasker.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.rel_return rel100 =null;

        AliasMasker.cube_by_clause_return cube_by_clause101 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:246:5: ( rel ( cube_by_clause ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:246:7: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1114);
            rel100=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel100.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:246:11: ( cube_by_clause )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:246:13: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1118);
            cube_by_clause101=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause101.getTree());


            if ( state.backtracking==0 ) {
            }
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_item"


    public static class cube_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:249:1: cube_by_clause : ^( BY cube_or_rollup ) ;
    public final AliasMasker.cube_by_clause_return cube_by_clause() throws RecognitionException {
        AliasMasker.cube_by_clause_return retval = new AliasMasker.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY102=null;
        AliasMasker.cube_or_rollup_return cube_or_rollup103 =null;


        CommonTree BY102_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:250:5: ( ^( BY cube_or_rollup ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:250:7: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY102=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1135); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY102_tree = (CommonTree)adaptor.dupNode(BY102);


            root_1 = (CommonTree)adaptor.becomeRoot(BY102_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1137);
            cube_or_rollup103=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup103.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_clause"


    public static class cube_or_rollup_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_or_rollup"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:253:1: cube_or_rollup : ( cube_rollup_list )+ ;
    public final AliasMasker.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        AliasMasker.cube_or_rollup_return retval = new AliasMasker.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.cube_rollup_list_return cube_rollup_list104 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:254:5: ( ( cube_rollup_list )+ )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:254:7: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:254:7: ( cube_rollup_list )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==CUBE||LA32_0==ROLLUP) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:254:7: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1152);
            	    cube_rollup_list104=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list104.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_or_rollup"


    public static class cube_rollup_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_rollup_list"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:257:1: cube_rollup_list : ^( ( CUBE | ROLLUP ) cube_by_expr_list ) ;
    public final AliasMasker.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        AliasMasker.cube_rollup_list_return retval = new AliasMasker.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set105=null;
        AliasMasker.cube_by_expr_list_return cube_by_expr_list106 =null;


        CommonTree set105_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:258:5: ( ^( ( CUBE | ROLLUP ) cube_by_expr_list ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:258:7: ^( ( CUBE | ROLLUP ) cube_by_expr_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set105=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==ROLLUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set105_tree = (CommonTree)adaptor.dupNode(set105);


                root_1 = (CommonTree)adaptor.becomeRoot(set105_tree, root_1);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1178);
            cube_by_expr_list106=cube_by_expr_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_by_expr_list106.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_rollup_list"


    public static class cube_by_expr_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr_list"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:261:1: cube_by_expr_list : ( cube_by_expr )+ ;
    public final AliasMasker.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        AliasMasker.cube_by_expr_list_return retval = new AliasMasker.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.cube_by_expr_return cube_by_expr107 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:262:5: ( ( cube_by_expr )+ )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:262:7: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:262:7: ( cube_by_expr )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==CUBE||LA33_0==DIV||LA33_0==DOLLARVAR||LA33_0==DOUBLENUMBER||LA33_0==FALSE||LA33_0==FLOATNUMBER||LA33_0==GROUP||LA33_0==INTEGER||LA33_0==LONGINTEGER||LA33_0==MINUS||LA33_0==PERCENT||LA33_0==PLUS||LA33_0==QUOTEDSTRING||LA33_0==STAR||LA33_0==TRUE||(LA33_0 >= BAG_VAL && LA33_0 <= BIN_EXPR)||(LA33_0 >= CAST_EXPR && LA33_0 <= EXPR_IN_PAREN)||LA33_0==FUNC_EVAL||LA33_0==IDENTIFIER||(LA33_0 >= MAP_VAL && LA33_0 <= NEG)||LA33_0==NULL||LA33_0==TUPLE_VAL) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:262:7: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1193);
            	    cube_by_expr107=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr107.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_expr_list"


    public static class cube_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:265:1: cube_by_expr : ( col_range | expr | STAR );
    public final AliasMasker.cube_by_expr_return cube_by_expr() throws RecognitionException {
        AliasMasker.cube_by_expr_return retval = new AliasMasker.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR110=null;
        AliasMasker.col_range_return col_range108 =null;

        AliasMasker.expr_return expr109 =null;


        CommonTree STAR110_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:266:5: ( col_range | expr | STAR )
            int alt34=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt34=1;
                }
                break;
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case IDENTIFIER:
            case MAP_VAL:
            case NEG:
            case NULL:
            case TUPLE_VAL:
                {
                alt34=2;
                }
                break;
            case STAR:
                {
                int LA34_3 = input.LA(2);

                if ( (LA34_3==DOWN) ) {
                    alt34=2;
                }
                else if ( (LA34_3==EOF||LA34_3==UP||LA34_3==CUBE||LA34_3==DIV||LA34_3==DOLLARVAR||LA34_3==DOUBLENUMBER||LA34_3==FALSE||LA34_3==FLOATNUMBER||LA34_3==GROUP||LA34_3==INTEGER||LA34_3==LONGINTEGER||LA34_3==MINUS||LA34_3==PERCENT||LA34_3==PLUS||LA34_3==QUOTEDSTRING||LA34_3==STAR||LA34_3==TRUE||(LA34_3 >= BAG_VAL && LA34_3 <= BIN_EXPR)||(LA34_3 >= CAST_EXPR && LA34_3 <= EXPR_IN_PAREN)||LA34_3==FUNC_EVAL||LA34_3==IDENTIFIER||(LA34_3 >= MAP_VAL && LA34_3 <= NEG)||LA34_3==NULL||LA34_3==TUPLE_VAL) ) {
                    alt34=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }

            switch (alt34) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:266:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1208);
                    col_range108=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range108.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:266:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1212);
                    expr109=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr109.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:266:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR110=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1216); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR110_tree = (CommonTree)adaptor.dupNode(STAR110);


                    adaptor.addChild(root_0, STAR110_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_expr"


    public static class group_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:269:1: group_clause : ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) ;
    public final AliasMasker.group_clause_return group_clause() throws RecognitionException {
        AliasMasker.group_clause_return retval = new AliasMasker.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set111=null;
        AliasMasker.group_item_return group_item112 =null;

        AliasMasker.group_type_return group_type113 =null;

        AliasMasker.partition_clause_return partition_clause114 =null;


        CommonTree set111_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:270:5: ( ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:270:7: ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set111=(CommonTree)input.LT(1);

            if ( input.LA(1)==COGROUP||input.LA(1)==GROUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set111_tree = (CommonTree)adaptor.dupNode(set111);


                root_1 = (CommonTree)adaptor.becomeRoot(set111_tree, root_1);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:270:30: ( group_item )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==COGROUP||(LA35_0 >= CROSS && LA35_0 <= CUBE)||LA35_0==DEFINE||LA35_0==DISTINCT||LA35_0==FILTER||LA35_0==FOREACH||LA35_0==GROUP||LA35_0==JOIN||(LA35_0 >= LIMIT && LA35_0 <= LOAD)||LA35_0==MAPREDUCE||LA35_0==ORDER||LA35_0==RANK||LA35_0==SAMPLE||LA35_0==SPLIT||(LA35_0 >= STORE && LA35_0 <= STREAM)||LA35_0==UNION||LA35_0==IDENTIFIER) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:270:30: group_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1242);
            	    group_item112=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item112.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:270:42: ( group_type )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==QUOTEDSTRING) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:270:42: group_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1245);
                    group_type113=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type113.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:270:54: ( partition_clause )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==PARTITION) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:270:54: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1248);
                    partition_clause114=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause114.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:273:1: group_type : QUOTEDSTRING ;
    public final AliasMasker.group_type_return group_type() throws RecognitionException {
        AliasMasker.group_type_return retval = new AliasMasker.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING115=null;

        CommonTree QUOTEDSTRING115_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:273:12: ( QUOTEDSTRING )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:273:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING115=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1260); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING115_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING115);


            adaptor.addChild(root_0, QUOTEDSTRING115_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_type"


    public static class group_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_item"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:276:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AliasMasker.group_item_return group_item() throws RecognitionException {
        AliasMasker.group_item_return retval = new AliasMasker.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL118=null;
        CommonTree ANY119=null;
        CommonTree set120=null;
        AliasMasker.rel_return rel116 =null;

        AliasMasker.join_group_by_clause_return join_group_by_clause117 =null;


        CommonTree ALL118_tree=null;
        CommonTree ANY119_tree=null;
        CommonTree set120_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:277:5: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:277:7: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1274);
            rel116=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel116.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:277:11: ( join_group_by_clause | ALL | ANY )
            int alt38=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt38=1;
                }
                break;
            case ALL:
                {
                alt38=2;
                }
                break;
            case ANY:
                {
                alt38=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }

            switch (alt38) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:277:13: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1278);
                    join_group_by_clause117=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause117.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:277:36: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL118=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL118_tree = (CommonTree)adaptor.dupNode(ALL118);


                    adaptor.addChild(root_0, ALL118_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:277:42: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY119=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1286); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY119_tree = (CommonTree)adaptor.dupNode(ANY119);


                    adaptor.addChild(root_0, ANY119_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:277:48: ( INNER | OUTER )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==INNER||LA39_0==OUTER) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set120=(CommonTree)input.LT(1);

                    if ( input.LA(1)==INNER||input.LA(1)==OUTER ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set120_tree = (CommonTree)adaptor.dupNode(set120);


                        adaptor.addChild(root_0, set120_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:280:1: rel : ( alias | ( op_clause ( parallel_clause )? ) );
    public final AliasMasker.rel_return rel() throws RecognitionException {
        AliasMasker.rel_return retval = new AliasMasker.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.alias_return alias121 =null;

        AliasMasker.op_clause_return op_clause122 =null;

        AliasMasker.parallel_clause_return parallel_clause123 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:281:5: ( alias | ( op_clause ( parallel_clause )? ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==IDENTIFIER) ) {
                alt41=1;
            }
            else if ( (LA41_0==COGROUP||(LA41_0 >= CROSS && LA41_0 <= CUBE)||LA41_0==DEFINE||LA41_0==DISTINCT||LA41_0==FILTER||LA41_0==FOREACH||LA41_0==GROUP||LA41_0==JOIN||(LA41_0 >= LIMIT && LA41_0 <= LOAD)||LA41_0==MAPREDUCE||LA41_0==ORDER||LA41_0==RANK||LA41_0==SAMPLE||LA41_0==SPLIT||(LA41_0 >= STORE && LA41_0 <= STREAM)||LA41_0==UNION) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:281:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1313);
                    alias121=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias121.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:281:15: ( op_clause ( parallel_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:281:15: ( op_clause ( parallel_clause )? )
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:281:17: op_clause ( parallel_clause )?
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1319);
                    op_clause122=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause122.getTree());


                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:281:27: ( parallel_clause )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==PARALLEL) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:281:27: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1321);
                            parallel_clause123=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause123.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:284:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AliasMasker.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AliasMasker.flatten_generated_item_return retval = new AliasMasker.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR127=null;
        AliasMasker.flatten_clause_return flatten_clause124 =null;

        AliasMasker.col_range_return col_range125 =null;

        AliasMasker.expr_return expr126 =null;

        AliasMasker.field_def_list_return field_def_list128 =null;


        CommonTree STAR127_tree=null;


        	inAsOrGenClause = true;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:291:5: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:291:7: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:291:7: ( flatten_clause | col_range | expr | STAR )
            int alt42=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt42=1;
                }
                break;
            case COL_RANGE:
                {
                alt42=2;
                }
                break;
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case IDENTIFIER:
            case MAP_VAL:
            case NEG:
            case NULL:
            case TUPLE_VAL:
                {
                alt42=3;
                }
                break;
            case STAR:
                {
                int LA42_4 = input.LA(2);

                if ( (LA42_4==DOWN) ) {
                    alt42=3;
                }
                else if ( (LA42_4==EOF||LA42_4==UP||LA42_4==CUBE||LA42_4==DIV||LA42_4==DOLLARVAR||LA42_4==DOUBLENUMBER||LA42_4==FALSE||LA42_4==FLATTEN||LA42_4==FLOATNUMBER||LA42_4==GROUP||LA42_4==INTEGER||LA42_4==LONGINTEGER||LA42_4==MINUS||LA42_4==PERCENT||LA42_4==PLUS||LA42_4==QUOTEDSTRING||LA42_4==STAR||LA42_4==TRUE||(LA42_4 >= BAG_VAL && LA42_4 <= BIN_EXPR)||(LA42_4 >= CAST_EXPR && LA42_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA42_4==FUNC_EVAL||LA42_4==IDENTIFIER||(LA42_4 >= MAP_VAL && LA42_4 <= NEG)||LA42_4==NULL||LA42_4==TUPLE_VAL) ) {
                    alt42=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }

            switch (alt42) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:291:9: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1350);
                    flatten_clause124=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause124.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:291:26: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1354);
                    col_range125=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range125.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:291:38: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1358);
                    expr126=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr126.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:291:45: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR127=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1362); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR127_tree = (CommonTree)adaptor.dupNode(STAR127);


                    adaptor.addChild(root_0, STAR127_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:291:52: ( field_def_list )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0 >= FIELD_DEF && LA43_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:291:52: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1366);
                    field_def_list128=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list128.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
            	inAsOrGenClause = false;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_generated_item"


    public static class flatten_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:294:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AliasMasker.flatten_clause_return flatten_clause() throws RecognitionException {
        AliasMasker.flatten_clause_return retval = new AliasMasker.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN129=null;
        AliasMasker.expr_return expr130 =null;


        CommonTree FLATTEN129_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:295:5: ( ^( FLATTEN expr ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:295:7: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN129=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1383); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN129_tree = (CommonTree)adaptor.dupNode(FLATTEN129);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN129_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1385);
            expr130=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr130.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_clause"


    public static class store_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "store_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:298:1: store_clause : ^( STORE alias filename ( func_clause )? ) ;
    public final AliasMasker.store_clause_return store_clause() throws RecognitionException {
        AliasMasker.store_clause_return retval = new AliasMasker.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE131=null;
        AliasMasker.alias_return alias132 =null;

        AliasMasker.filename_return filename133 =null;

        AliasMasker.func_clause_return func_clause134 =null;


        CommonTree STORE131_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:299:5: ( ^( STORE alias filename ( func_clause )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:299:7: ^( STORE alias filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE131=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1403); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE131_tree = (CommonTree)adaptor.dupNode(STORE131);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE131_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_store_clause1405);
            alias132=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias132.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1407);
            filename133=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename133.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:299:31: ( func_clause )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==FUNC||LA44_0==FUNC_REF) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:299:31: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1409);
                    func_clause134=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause134.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "store_clause"


    public static class filter_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:302:1: filter_clause : ^( FILTER rel cond ) ;
    public final AliasMasker.filter_clause_return filter_clause() throws RecognitionException {
        AliasMasker.filter_clause_return retval = new AliasMasker.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER135=null;
        AliasMasker.rel_return rel136 =null;

        AliasMasker.cond_return cond137 =null;


        CommonTree FILTER135_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:303:5: ( ^( FILTER rel cond ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:303:7: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER135=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1428); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER135_tree = (CommonTree)adaptor.dupNode(FILTER135);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER135_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1430);
            rel136=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel136.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1432);
            cond137=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond137.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filter_clause"


    public static class cond_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cond"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:306:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | func_eval | ^( BOOL_COND expr ) );
    public final AliasMasker.cond_return cond() throws RecognitionException {
        AliasMasker.cond_return retval = new AliasMasker.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR138=null;
        CommonTree AND141=null;
        CommonTree NOT144=null;
        CommonTree NULL146=null;
        CommonTree NOT148=null;
        CommonTree BOOL_COND153=null;
        AliasMasker.cond_return cond139 =null;

        AliasMasker.cond_return cond140 =null;

        AliasMasker.cond_return cond142 =null;

        AliasMasker.cond_return cond143 =null;

        AliasMasker.cond_return cond145 =null;

        AliasMasker.expr_return expr147 =null;

        AliasMasker.rel_op_return rel_op149 =null;

        AliasMasker.expr_return expr150 =null;

        AliasMasker.expr_return expr151 =null;

        AliasMasker.func_eval_return func_eval152 =null;

        AliasMasker.expr_return expr154 =null;


        CommonTree OR138_tree=null;
        CommonTree AND141_tree=null;
        CommonTree NOT144_tree=null;
        CommonTree NULL146_tree=null;
        CommonTree NOT148_tree=null;
        CommonTree BOOL_COND153_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:307:5: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | func_eval | ^( BOOL_COND expr ) )
            int alt46=7;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt46=1;
                }
                break;
            case AND:
                {
                alt46=2;
                }
                break;
            case NOT:
                {
                alt46=3;
                }
                break;
            case NULL:
                {
                alt46=4;
                }
                break;
            case NUM_OP_EQ:
            case NUM_OP_GT:
            case NUM_OP_GTE:
            case NUM_OP_LT:
            case NUM_OP_LTE:
            case NUM_OP_NE:
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt46=5;
                }
                break;
            case FUNC_EVAL:
                {
                alt46=6;
                }
                break;
            case BOOL_COND:
                {
                alt46=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:307:7: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR138=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1450); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR138_tree = (CommonTree)adaptor.dupNode(OR138);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR138_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1452);
                    cond139=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond139.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1454);
                    cond140=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond140.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:308:7: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND141=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1466); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND141_tree = (CommonTree)adaptor.dupNode(AND141);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND141_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1468);
                    cond142=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond142.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1470);
                    cond143=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond143.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:309:7: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT144=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1482); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT144_tree = (CommonTree)adaptor.dupNode(NOT144);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT144_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1484);
                    cond145=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond145.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:310:7: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL146=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1496); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL146_tree = (CommonTree)adaptor.dupNode(NULL146);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL146_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1498);
                    expr147=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr147.getTree());


                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:310:20: ( NOT )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==NOT) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:310:20: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT148=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1500); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT148_tree = (CommonTree)adaptor.dupNode(NOT148);


                            adaptor.addChild(root_1, NOT148_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:311:7: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond1513);
                    rel_op149=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op149.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1515);
                    expr150=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr150.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1517);
                    expr151=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr151.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:312:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond1527);
                    func_eval152=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval152.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:313:7: ^( BOOL_COND expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND153=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond1537); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND153_tree = (CommonTree)adaptor.dupNode(BOOL_COND153);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND153_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1539);
                    expr154=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr154.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cond"


    public static class func_eval_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:316:1: func_eval : ^( FUNC_EVAL func_name ( real_arg )* ) ;
    public final AliasMasker.func_eval_return func_eval() throws RecognitionException {
        AliasMasker.func_eval_return retval = new AliasMasker.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL155=null;
        AliasMasker.func_name_return func_name156 =null;

        AliasMasker.real_arg_return real_arg157 =null;


        CommonTree FUNC_EVAL155_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:317:5: ( ^( FUNC_EVAL func_name ( real_arg )* ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:317:7: ^( FUNC_EVAL func_name ( real_arg )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FUNC_EVAL155=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1556); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNC_EVAL155_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL155);


            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL155_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_func_eval1558);
            func_name156=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name156.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:317:30: ( real_arg )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==CUBE||LA47_0==DIV||LA47_0==DOLLARVAR||LA47_0==DOUBLENUMBER||LA47_0==FALSE||LA47_0==FLOATNUMBER||LA47_0==GROUP||LA47_0==INTEGER||LA47_0==LONGINTEGER||LA47_0==MINUS||LA47_0==PERCENT||LA47_0==PLUS||LA47_0==QUOTEDSTRING||LA47_0==STAR||LA47_0==TRUE||(LA47_0 >= BAG_VAL && LA47_0 <= BIN_EXPR)||LA47_0==CAST_EXPR||LA47_0==EXPR_IN_PAREN||LA47_0==FUNC_EVAL||LA47_0==IDENTIFIER||(LA47_0 >= MAP_VAL && LA47_0 <= NEG)||LA47_0==NULL||LA47_0==TUPLE_VAL) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:317:30: real_arg
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_real_arg_in_func_eval1560);
            	    real_arg157=real_arg();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, real_arg157.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_eval"


    public static class real_arg_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:320:1: real_arg : ( expr | STAR );
    public final AliasMasker.real_arg_return real_arg() throws RecognitionException {
        AliasMasker.real_arg_return retval = new AliasMasker.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR159=null;
        AliasMasker.expr_return expr158 =null;


        CommonTree STAR159_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:321:5: ( expr | STAR )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==CUBE||LA48_0==DIV||LA48_0==DOLLARVAR||LA48_0==DOUBLENUMBER||LA48_0==FALSE||LA48_0==FLOATNUMBER||LA48_0==GROUP||LA48_0==INTEGER||LA48_0==LONGINTEGER||LA48_0==MINUS||LA48_0==PERCENT||LA48_0==PLUS||LA48_0==QUOTEDSTRING||LA48_0==TRUE||(LA48_0 >= BAG_VAL && LA48_0 <= BIN_EXPR)||LA48_0==CAST_EXPR||LA48_0==EXPR_IN_PAREN||LA48_0==FUNC_EVAL||LA48_0==IDENTIFIER||(LA48_0 >= MAP_VAL && LA48_0 <= NEG)||LA48_0==NULL||LA48_0==TUPLE_VAL) ) {
                alt48=1;
            }
            else if ( (LA48_0==STAR) ) {
                int LA48_2 = input.LA(2);

                if ( (LA48_2==DOWN) ) {
                    alt48=1;
                }
                else if ( (LA48_2==EOF||LA48_2==UP||LA48_2==CUBE||LA48_2==DIV||LA48_2==DOLLARVAR||LA48_2==DOUBLENUMBER||LA48_2==FALSE||LA48_2==FLOATNUMBER||LA48_2==GROUP||LA48_2==INTEGER||LA48_2==LONGINTEGER||LA48_2==MINUS||LA48_2==PERCENT||LA48_2==PLUS||LA48_2==QUOTEDSTRING||LA48_2==STAR||LA48_2==TRUE||(LA48_2 >= BAG_VAL && LA48_2 <= BIN_EXPR)||LA48_2==CAST_EXPR||LA48_2==EXPR_IN_PAREN||LA48_2==FUNC_EVAL||LA48_2==IDENTIFIER||(LA48_2 >= MAP_VAL && LA48_2 <= NEG)||LA48_2==NULL||LA48_2==TUPLE_VAL) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }
            switch (alt48) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:321:7: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg1577);
                    expr158=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr158.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:321:14: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR159=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg1581); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR159_tree = (CommonTree)adaptor.dupNode(STAR159);


                    adaptor.addChild(root_0, STAR159_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "real_arg"


    public static class expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:324:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AliasMasker.expr_return expr() throws RecognitionException {
        AliasMasker.expr_return retval = new AliasMasker.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS160=null;
        CommonTree MINUS163=null;
        CommonTree STAR166=null;
        CommonTree DIV169=null;
        CommonTree PERCENT172=null;
        CommonTree CAST_EXPR175=null;
        CommonTree NEG180=null;
        CommonTree CAST_EXPR182=null;
        CommonTree EXPR_IN_PAREN185=null;
        AliasMasker.expr_return expr161 =null;

        AliasMasker.expr_return expr162 =null;

        AliasMasker.expr_return expr164 =null;

        AliasMasker.expr_return expr165 =null;

        AliasMasker.expr_return expr167 =null;

        AliasMasker.expr_return expr168 =null;

        AliasMasker.expr_return expr170 =null;

        AliasMasker.expr_return expr171 =null;

        AliasMasker.expr_return expr173 =null;

        AliasMasker.expr_return expr174 =null;

        AliasMasker.type_return type176 =null;

        AliasMasker.expr_return expr177 =null;

        AliasMasker.const_expr_return const_expr178 =null;

        AliasMasker.var_expr_return var_expr179 =null;

        AliasMasker.expr_return expr181 =null;

        AliasMasker.type_cast_return type_cast183 =null;

        AliasMasker.expr_return expr184 =null;

        AliasMasker.expr_return expr186 =null;


        CommonTree PLUS160_tree=null;
        CommonTree MINUS163_tree=null;
        CommonTree STAR166_tree=null;
        CommonTree DIV169_tree=null;
        CommonTree PERCENT172_tree=null;
        CommonTree CAST_EXPR175_tree=null;
        CommonTree NEG180_tree=null;
        CommonTree CAST_EXPR182_tree=null;
        CommonTree EXPR_IN_PAREN185_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:325:5: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt49=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt49=1;
                }
                break;
            case MINUS:
                {
                int LA49_2 = input.LA(2);

                if ( (synpred94_AliasMasker()) ) {
                    alt49=2;
                }
                else if ( (synpred99_AliasMasker()) ) {
                    alt49=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt49=3;
                }
                break;
            case DIV:
                {
                alt49=4;
                }
                break;
            case PERCENT:
                {
                alt49=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA49_6 = input.LA(2);

                if ( (synpred98_AliasMasker()) ) {
                    alt49=6;
                }
                else if ( (synpred102_AliasMasker()) ) {
                    alt49=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 6, input);

                    throw nvae;

                }
                }
                break;
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case MAP_VAL:
            case NULL:
            case TUPLE_VAL:
                {
                alt49=7;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case BIN_EXPR:
            case FUNC_EVAL:
            case IDENTIFIER:
                {
                alt49=8;
                }
                break;
            case NEG:
                {
                alt49=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt49=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }

            switch (alt49) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:325:7: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS160=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1597); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS160_tree = (CommonTree)adaptor.dupNode(PLUS160);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS160_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1599);
                    expr161=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr161.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1601);
                    expr162=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr162.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:326:7: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS163=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1613); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS163_tree = (CommonTree)adaptor.dupNode(MINUS163);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS163_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1615);
                    expr164=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr164.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1617);
                    expr165=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr165.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:327:7: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR166=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr1629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR166_tree = (CommonTree)adaptor.dupNode(STAR166);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR166_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1631);
                    expr167=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr167.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1633);
                    expr168=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr168.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:328:7: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV169=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1645); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV169_tree = (CommonTree)adaptor.dupNode(DIV169);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV169_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1647);
                    expr170=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr170.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1649);
                    expr171=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr171.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:329:7: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT172=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr1661); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT172_tree = (CommonTree)adaptor.dupNode(PERCENT172);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT172_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1663);
                    expr173=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr173.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1665);
                    expr174=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr174.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:330:7: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR175=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1677); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR175_tree = (CommonTree)adaptor.dupNode(CAST_EXPR175);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR175_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr1679);
                    type176=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type176.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1681);
                    expr177=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr177.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:331:7: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr1691);
                    const_expr178=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr178.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:332:7: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr1699);
                    var_expr179=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr179.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:333:7: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG180=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr1709); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG180_tree = (CommonTree)adaptor.dupNode(NEG180);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG180_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1711);
                    expr181=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr181.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:334:7: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR182=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1723); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR182_tree = (CommonTree)adaptor.dupNode(CAST_EXPR182);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR182_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr1725);
                    type_cast183=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast183.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1727);
                    expr184=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr184.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:335:7: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN185=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr1739); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN185_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN185);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN185_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1741);
                    expr186=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr186.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type_cast"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:338:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AliasMasker.type_cast_return type_cast() throws RecognitionException {
        AliasMasker.type_cast_return retval = new AliasMasker.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.simple_type_return simple_type187 =null;

        AliasMasker.map_type_return map_type188 =null;

        AliasMasker.tuple_type_cast_return tuple_type_cast189 =null;

        AliasMasker.bag_type_cast_return bag_type_cast190 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:339:5: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt50=4;
            switch ( input.LA(1) ) {
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DATETIME:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt50=1;
                }
                break;
            case MAP_TYPE:
                {
                alt50=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt50=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt50=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }

            switch (alt50) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:339:7: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast1757);
                    simple_type187=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type187.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:339:21: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast1761);
                    map_type188=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type188.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:339:32: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast1765);
                    tuple_type_cast189=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast189.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:339:50: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast1769);
                    bag_type_cast190=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast190.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type_cast"


    public static class tuple_type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type_cast"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:342:1: tuple_type_cast : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final AliasMasker.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AliasMasker.tuple_type_cast_return retval = new AliasMasker.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST191=null;
        AliasMasker.type_cast_return type_cast192 =null;


        CommonTree TUPLE_TYPE_CAST191_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:343:5: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:343:7: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST191=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1785); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST191_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST191);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST191_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:343:26: ( type_cast )*
                loop51:
                do {
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==BOOLEAN||LA51_0==BYTEARRAY||LA51_0==CHARARRAY||LA51_0==DATETIME||LA51_0==DOUBLE||LA51_0==FLOAT||LA51_0==INT||LA51_0==LONG||LA51_0==BAG_TYPE_CAST||LA51_0==MAP_TYPE||LA51_0==TUPLE_TYPE_CAST) ) {
                        alt51=1;
                    }


                    switch (alt51) {
                	case 1 :
                	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:343:26: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast1787);
                	    type_cast192=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast192.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop51;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type_cast"


    public static class bag_type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:346:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AliasMasker.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AliasMasker.bag_type_cast_return retval = new AliasMasker.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST193=null;
        AliasMasker.tuple_type_cast_return tuple_type_cast194 =null;


        CommonTree BAG_TYPE_CAST193_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:347:5: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:347:7: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST193=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1806); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST193_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST193);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST193_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:347:24: ( tuple_type_cast )?
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==TUPLE_TYPE_CAST) ) {
                    alt52=1;
                }
                switch (alt52) {
                    case 1 :
                        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:347:24: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast1808);
                        tuple_type_cast194=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast194.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type_cast"


    public static class var_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:350:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AliasMasker.var_expr_return var_expr() throws RecognitionException {
        AliasMasker.var_expr_return retval = new AliasMasker.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.projectable_expr_return projectable_expr195 =null;

        AliasMasker.dot_proj_return dot_proj196 =null;

        AliasMasker.pound_proj_return pound_proj197 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:351:5: ( projectable_expr ( dot_proj | pound_proj )* )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:351:7: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr1825);
            projectable_expr195=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr195.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:351:24: ( dot_proj | pound_proj )*
            loop53:
            do {
                int alt53=3;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==PERIOD) ) {
                    alt53=1;
                }
                else if ( (LA53_0==POUND) ) {
                    alt53=2;
                }


                switch (alt53) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:351:26: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr1829);
            	    dot_proj196=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj196.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:351:37: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr1833);
            	    pound_proj197=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj197.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "var_expr"


    public static class projectable_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "projectable_expr"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:354:1: projectable_expr : ( func_eval | col_ref | bin_expr );
    public final AliasMasker.projectable_expr_return projectable_expr() throws RecognitionException {
        AliasMasker.projectable_expr_return retval = new AliasMasker.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.func_eval_return func_eval198 =null;

        AliasMasker.col_ref_return col_ref199 =null;

        AliasMasker.bin_expr_return bin_expr200 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:355:5: ( func_eval | col_ref | bin_expr )
            int alt54=3;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
                {
                alt54=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt54=2;
                }
                break;
            case BIN_EXPR:
                {
                alt54=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }

            switch (alt54) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:355:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr1849);
                    func_eval198=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval198.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:355:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr1853);
                    col_ref199=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref199.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:355:29: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr1857);
                    bin_expr200=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr200.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "projectable_expr"


    public static class dot_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dot_proj"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:358:1: dot_proj : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final AliasMasker.dot_proj_return dot_proj() throws RecognitionException {
        AliasMasker.dot_proj_return retval = new AliasMasker.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD201=null;
        AliasMasker.col_alias_or_index_return col_alias_or_index202 =null;


        CommonTree PERIOD201_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:359:5: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:359:7: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD201=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj1873); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD201_tree = (CommonTree)adaptor.dupNode(PERIOD201);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD201_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:359:17: ( col_alias_or_index )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==CUBE||LA55_0==DOLLARVAR||LA55_0==GROUP||LA55_0==IDENTIFIER) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:359:17: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj1875);
            	    col_alias_or_index202=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index202.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt55 >= 1 ) break loop55;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dot_proj"


    public static class col_alias_or_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:362:1: col_alias_or_index : ( col_alias | col_index );
    public final AliasMasker.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AliasMasker.col_alias_or_index_return retval = new AliasMasker.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.col_alias_return col_alias203 =null;

        AliasMasker.col_index_return col_index204 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:362:20: ( col_alias | col_index )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==CUBE||LA56_0==GROUP||LA56_0==IDENTIFIER) ) {
                alt56=1;
            }
            else if ( (LA56_0==DOLLARVAR) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }
            switch (alt56) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:362:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index1887);
                    col_alias203=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias203.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:362:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index1891);
                    col_index204=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index204.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias_or_index"


    public static class col_alias_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:365:1: col_alias : ( GROUP | CUBE | IDENTIFIER );
    public final AliasMasker.col_alias_return col_alias() throws RecognitionException {
        AliasMasker.col_alias_return retval = new AliasMasker.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set205=null;

        CommonTree set205_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:366:5: ( GROUP | CUBE | IDENTIFIER )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set205=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set205_tree = (CommonTree)adaptor.dupNode(set205);


                adaptor.addChild(root_0, set205_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias"


    public static class col_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:371:1: col_index : DOLLARVAR ;
    public final AliasMasker.col_index_return col_index() throws RecognitionException {
        AliasMasker.col_index_return retval = new AliasMasker.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR206=null;

        CommonTree DOLLARVAR206_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:372:5: ( DOLLARVAR )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:372:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR206=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index1937); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR206_tree = (CommonTree)adaptor.dupNode(DOLLARVAR206);


            adaptor.addChild(root_0, DOLLARVAR206_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_index"


    public static class col_range_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:375:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AliasMasker.col_range_return col_range() throws RecognitionException {
        AliasMasker.col_range_return retval = new AliasMasker.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE207=null;
        CommonTree DOUBLE_PERIOD209=null;
        AliasMasker.col_ref_return col_ref208 =null;

        AliasMasker.col_ref_return col_ref210 =null;


        CommonTree COL_RANGE207_tree=null;
        CommonTree DOUBLE_PERIOD209_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:375:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:375:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE207=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range1948); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE207_tree = (CommonTree)adaptor.dupNode(COL_RANGE207);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE207_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:375:26: ( col_ref )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==CUBE||LA57_0==DOLLARVAR||LA57_0==GROUP||LA57_0==IDENTIFIER) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:375:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range1950);
                    col_ref208=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref208.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD209=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range1953); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD209_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD209);


            adaptor.addChild(root_1, DOUBLE_PERIOD209_tree);
            }


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:375:49: ( col_ref )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==CUBE||LA58_0==DOLLARVAR||LA58_0==GROUP||LA58_0==IDENTIFIER) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:375:49: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range1955);
                    col_ref210=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref210.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_range"


    public static class pound_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pound_proj"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:378:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AliasMasker.pound_proj_return pound_proj() throws RecognitionException {
        AliasMasker.pound_proj_return retval = new AliasMasker.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND211=null;
        CommonTree set212=null;

        CommonTree POUND211_tree=null;
        CommonTree set212_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:379:5: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:379:7: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND211=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj1972); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND211_tree = (CommonTree)adaptor.dupNode(POUND211);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND211_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            set212=(CommonTree)input.LT(1);

            if ( input.LA(1)==QUOTEDSTRING||input.LA(1)==NULL ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set212_tree = (CommonTree)adaptor.dupNode(set212);


                adaptor.addChild(root_1, set212_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pound_proj"


    public static class bin_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bin_expr"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:382:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AliasMasker.bin_expr_return bin_expr() throws RecognitionException {
        AliasMasker.bin_expr_return retval = new AliasMasker.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR213=null;
        AliasMasker.cond_return cond214 =null;

        AliasMasker.expr_return expr215 =null;

        AliasMasker.expr_return expr216 =null;


        CommonTree BIN_EXPR213_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:383:5: ( ^( BIN_EXPR cond expr expr ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:383:7: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR213=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr1999); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR213_tree = (CommonTree)adaptor.dupNode(BIN_EXPR213);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR213_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr2001);
            cond214=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond214.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2003);
            expr215=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr215.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2005);
            expr216=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr216.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bin_expr"


    public static class limit_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limit_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:386:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AliasMasker.limit_clause_return limit_clause() throws RecognitionException {
        AliasMasker.limit_clause_return retval = new AliasMasker.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT217=null;
        CommonTree INTEGER219=null;
        CommonTree LONGINTEGER220=null;
        AliasMasker.rel_return rel218 =null;

        AliasMasker.expr_return expr221 =null;


        CommonTree LIMIT217_tree=null;
        CommonTree INTEGER219_tree=null;
        CommonTree LONGINTEGER220_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:387:5: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:387:7: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT217=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause2022); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT217_tree = (CommonTree)adaptor.dupNode(LIMIT217);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT217_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause2024);
            rel218=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel218.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:387:20: ( INTEGER | LONGINTEGER | expr )
            int alt59=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA59_1 = input.LA(2);

                if ( (synpred119_AliasMasker()) ) {
                    alt59=1;
                }
                else if ( (true) ) {
                    alt59=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA59_2 = input.LA(2);

                if ( (synpred120_AliasMasker()) ) {
                    alt59=2;
                }
                else if ( (true) ) {
                    alt59=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 2, input);

                    throw nvae;

                }
                }
                break;
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case MINUS:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case STAR:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case IDENTIFIER:
            case MAP_VAL:
            case NEG:
            case NULL:
            case TUPLE_VAL:
                {
                alt59=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }

            switch (alt59) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:387:22: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER219=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause2028); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER219_tree = (CommonTree)adaptor.dupNode(INTEGER219);


                    adaptor.addChild(root_1, INTEGER219_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:387:32: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER220=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause2032); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER220_tree = (CommonTree)adaptor.dupNode(LONGINTEGER220);


                    adaptor.addChild(root_1, LONGINTEGER220_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:387:46: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause2036);
                    expr221=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr221.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "limit_clause"


    public static class sample_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sample_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:390:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AliasMasker.sample_clause_return sample_clause() throws RecognitionException {
        AliasMasker.sample_clause_return retval = new AliasMasker.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE222=null;
        CommonTree DOUBLENUMBER224=null;
        AliasMasker.rel_return rel223 =null;

        AliasMasker.expr_return expr225 =null;


        CommonTree SAMPLE222_tree=null;
        CommonTree DOUBLENUMBER224_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:391:5: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:391:8: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE222=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause2056); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE222_tree = (CommonTree)adaptor.dupNode(SAMPLE222);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE222_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause2058);
            rel223=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel223.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:391:22: ( DOUBLENUMBER | expr )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==DOUBLENUMBER) ) {
                int LA60_1 = input.LA(2);

                if ( (synpred121_AliasMasker()) ) {
                    alt60=1;
                }
                else if ( (true) ) {
                    alt60=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA60_0==CUBE||LA60_0==DIV||LA60_0==DOLLARVAR||LA60_0==FALSE||LA60_0==FLOATNUMBER||LA60_0==GROUP||LA60_0==INTEGER||LA60_0==LONGINTEGER||LA60_0==MINUS||LA60_0==PERCENT||LA60_0==PLUS||LA60_0==QUOTEDSTRING||LA60_0==STAR||LA60_0==TRUE||(LA60_0 >= BAG_VAL && LA60_0 <= BIN_EXPR)||LA60_0==CAST_EXPR||LA60_0==EXPR_IN_PAREN||LA60_0==FUNC_EVAL||LA60_0==IDENTIFIER||(LA60_0 >= MAP_VAL && LA60_0 <= NEG)||LA60_0==NULL||LA60_0==TUPLE_VAL) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }
            switch (alt60) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:391:24: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER224=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause2062); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER224_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER224);


                    adaptor.addChild(root_1, DOUBLENUMBER224_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:391:39: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause2066);
                    expr225=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr225.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sample_clause"


    public static class rank_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:394:1: rank_clause : ^( RANK rel ( rank_by_statement )? ) ;
    public final AliasMasker.rank_clause_return rank_clause() throws RecognitionException {
        AliasMasker.rank_clause_return retval = new AliasMasker.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK226=null;
        AliasMasker.rel_return rel227 =null;

        AliasMasker.rank_by_statement_return rank_by_statement228 =null;


        CommonTree RANK226_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:395:2: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:395:4: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK226=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause2082); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK226_tree = (CommonTree)adaptor.dupNode(RANK226);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK226_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause2084);
            rel227=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel227.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:395:16: ( rank_by_statement )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==BY) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:395:18: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause2088);
                    rank_by_statement228=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement228.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_clause"


    public static class rank_by_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_statement"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:398:1: rank_by_statement : ^( BY rank_by_clause ( DENSE )? ) ;
    public final AliasMasker.rank_by_statement_return rank_by_statement() throws RecognitionException {
        AliasMasker.rank_by_statement_return retval = new AliasMasker.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY229=null;
        CommonTree DENSE231=null;
        AliasMasker.rank_by_clause_return rank_by_clause230 =null;


        CommonTree BY229_tree=null;
        CommonTree DENSE231_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:399:2: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:399:4: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY229=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement2105); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY229_tree = (CommonTree)adaptor.dupNode(BY229);


            root_1 = (CommonTree)adaptor.becomeRoot(BY229_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement2107);
            rank_by_clause230=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause230.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:399:25: ( DENSE )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==DENSE) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:399:27: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE231=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement2111); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE231_tree = (CommonTree)adaptor.dupNode(DENSE231);


                    adaptor.addChild(root_1, DENSE231_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_by_statement"


    public static class rank_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:402:1: rank_by_clause : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final AliasMasker.rank_by_clause_return rank_by_clause() throws RecognitionException {
        AliasMasker.rank_by_clause_return retval = new AliasMasker.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR232=null;
        CommonTree set233=null;
        AliasMasker.rank_col_return rank_col234 =null;


        CommonTree STAR232_tree=null;
        CommonTree set233_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:403:2: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==STAR) ) {
                alt65=1;
            }
            else if ( (LA65_0==CUBE||LA65_0==DOLLARVAR||LA65_0==GROUP||LA65_0==COL_RANGE||LA65_0==IDENTIFIER) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;

            }
            switch (alt65) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:403:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR232=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause2126); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR232_tree = (CommonTree)adaptor.dupNode(STAR232);


                    adaptor.addChild(root_0, STAR232_tree);
                    }


                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:403:9: ( ASC | DESC )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==ASC||LA63_0==DESC) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set233=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set233_tree = (CommonTree)adaptor.dupNode(set233);


                                adaptor.addChild(root_0, set233_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:404:7: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:404:7: ( rank_col )+
                    int cnt64=0;
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==CUBE||LA64_0==DOLLARVAR||LA64_0==GROUP||LA64_0==COL_RANGE||LA64_0==IDENTIFIER) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:404:7: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause2145);
                    	    rank_col234=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col234.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt64 >= 1 ) break loop64;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(64, input);
                                throw eee;
                        }
                        cnt64++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_by_clause"


    public static class rank_col_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_col"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:407:1: rank_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AliasMasker.rank_col_return rank_col() throws RecognitionException {
        AliasMasker.rank_col_return retval = new AliasMasker.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set237=null;
        AliasMasker.col_range_return col_range235 =null;

        AliasMasker.col_ref_return col_ref236 =null;


        CommonTree set237_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:408:2: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:408:4: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:408:4: ( col_range | col_ref )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==COL_RANGE) ) {
                alt66=1;
            }
            else if ( (LA66_0==CUBE||LA66_0==DOLLARVAR||LA66_0==GROUP||LA66_0==IDENTIFIER) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;

            }
            switch (alt66) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:408:6: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col2158);
                    col_range235=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range235.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:408:18: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col2162);
                    col_ref236=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref236.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:408:28: ( ASC | DESC )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==ASC||LA67_0==DESC) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set237=(CommonTree)input.LT(1);

                    if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set237_tree = (CommonTree)adaptor.dupNode(set237);


                        adaptor.addChild(root_0, set237_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_col"


    public static class order_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:411:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AliasMasker.order_clause_return order_clause() throws RecognitionException {
        AliasMasker.order_clause_return retval = new AliasMasker.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER238=null;
        AliasMasker.rel_return rel239 =null;

        AliasMasker.order_by_clause_return order_by_clause240 =null;

        AliasMasker.func_clause_return func_clause241 =null;


        CommonTree ORDER238_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:412:5: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:412:7: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER238=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause2190); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER238_tree = (CommonTree)adaptor.dupNode(ORDER238);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER238_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause2192);
            rel239=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel239.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause2194);
            order_by_clause240=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause240.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:412:36: ( func_clause )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==FUNC||LA68_0==FUNC_REF) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:412:36: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause2196);
                    func_clause241=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause241.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_clause"


    public static class order_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_by_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:415:1: order_by_clause : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final AliasMasker.order_by_clause_return order_by_clause() throws RecognitionException {
        AliasMasker.order_by_clause_return retval = new AliasMasker.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR242=null;
        CommonTree set243=null;
        AliasMasker.order_col_return order_col244 =null;


        CommonTree STAR242_tree=null;
        CommonTree set243_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:416:5: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==STAR) ) {
                alt71=1;
            }
            else if ( (LA71_0==CUBE||LA71_0==DOLLARVAR||LA71_0==GROUP||LA71_0==COL_RANGE||LA71_0==IDENTIFIER) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }
            switch (alt71) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:416:7: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR242=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause2212); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR242_tree = (CommonTree)adaptor.dupNode(STAR242);


                    adaptor.addChild(root_0, STAR242_tree);
                    }


                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:416:12: ( ASC | DESC )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==ASC||LA69_0==DESC) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set243=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set243_tree = (CommonTree)adaptor.dupNode(set243);


                                adaptor.addChild(root_0, set243_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:417:7: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:417:7: ( order_col )+
                    int cnt70=0;
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==CUBE||LA70_0==DOLLARVAR||LA70_0==GROUP||LA70_0==COL_RANGE||LA70_0==IDENTIFIER) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:417:7: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause2231);
                    	    order_col244=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col244.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt70 >= 1 ) break loop70;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(70, input);
                                throw eee;
                        }
                        cnt70++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_by_clause"


    public static class order_col_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_col"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:420:1: order_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AliasMasker.order_col_return order_col() throws RecognitionException {
        AliasMasker.order_col_return retval = new AliasMasker.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set247=null;
        AliasMasker.col_range_return col_range245 =null;

        AliasMasker.col_ref_return col_ref246 =null;


        CommonTree set247_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:421:5: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:421:7: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:421:7: ( col_range | col_ref )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==COL_RANGE) ) {
                alt72=1;
            }
            else if ( (LA72_0==CUBE||LA72_0==DOLLARVAR||LA72_0==GROUP||LA72_0==IDENTIFIER) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }
            switch (alt72) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:421:8: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col2246);
                    col_range245=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range245.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:421:20: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col2250);
                    col_ref246=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref246.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:421:29: ( ASC | DESC )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==ASC||LA73_0==DESC) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set247=(CommonTree)input.LT(1);

                    if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set247_tree = (CommonTree)adaptor.dupNode(set247);


                        adaptor.addChild(root_0, set247_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_col"


    public static class distinct_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "distinct_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:424:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AliasMasker.distinct_clause_return distinct_clause() throws RecognitionException {
        AliasMasker.distinct_clause_return retval = new AliasMasker.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT248=null;
        AliasMasker.rel_return rel249 =null;

        AliasMasker.partition_clause_return partition_clause250 =null;


        CommonTree DISTINCT248_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:425:5: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:425:7: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT248=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause2277); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT248_tree = (CommonTree)adaptor.dupNode(DISTINCT248);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT248_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause2279);
            rel249=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel249.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:425:23: ( partition_clause )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==PARTITION) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:425:23: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause2281);
                    partition_clause250=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause250.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "distinct_clause"


    public static class partition_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partition_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:428:1: partition_clause : ^( PARTITION func_name ) ;
    public final AliasMasker.partition_clause_return partition_clause() throws RecognitionException {
        AliasMasker.partition_clause_return retval = new AliasMasker.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION251=null;
        AliasMasker.func_name_return func_name252 =null;


        CommonTree PARTITION251_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:429:5: ( ^( PARTITION func_name ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:429:7: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION251=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause2299); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION251_tree = (CommonTree)adaptor.dupNode(PARTITION251);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION251_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause2301);
            func_name252=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name252.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "partition_clause"


    public static class cross_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cross_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:432:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AliasMasker.cross_clause_return cross_clause() throws RecognitionException {
        AliasMasker.cross_clause_return retval = new AliasMasker.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS253=null;
        AliasMasker.rel_list_return rel_list254 =null;

        AliasMasker.partition_clause_return partition_clause255 =null;


        CommonTree CROSS253_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:433:5: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:433:7: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS253=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause2318); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS253_tree = (CommonTree)adaptor.dupNode(CROSS253);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS253_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause2320);
            rel_list254=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list254.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:433:25: ( partition_clause )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==PARTITION) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:433:25: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause2322);
                    partition_clause255=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause255.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cross_clause"


    public static class rel_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_list"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:436:1: rel_list : ( rel )+ ;
    public final AliasMasker.rel_list_return rel_list() throws RecognitionException {
        AliasMasker.rel_list_return retval = new AliasMasker.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.rel_return rel256 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:437:5: ( ( rel )+ )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:437:7: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:437:7: ( rel )+
            int cnt76=0;
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==COGROUP||(LA76_0 >= CROSS && LA76_0 <= CUBE)||LA76_0==DEFINE||LA76_0==DISTINCT||LA76_0==FILTER||LA76_0==FOREACH||LA76_0==GROUP||LA76_0==JOIN||(LA76_0 >= LIMIT && LA76_0 <= LOAD)||LA76_0==MAPREDUCE||LA76_0==ORDER||LA76_0==RANK||LA76_0==SAMPLE||LA76_0==SPLIT||(LA76_0 >= STORE && LA76_0 <= STREAM)||LA76_0==UNION||LA76_0==IDENTIFIER) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:437:7: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list2338);
            	    rel256=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel256.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt76 >= 1 ) break loop76;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(76, input);
                        throw eee;
                }
                cnt76++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_list"


    public static class join_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:440:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AliasMasker.join_clause_return join_clause() throws RecognitionException {
        AliasMasker.join_clause_return retval = new AliasMasker.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN257=null;
        AliasMasker.join_sub_clause_return join_sub_clause258 =null;

        AliasMasker.join_type_return join_type259 =null;

        AliasMasker.partition_clause_return partition_clause260 =null;


        CommonTree JOIN257_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:441:5: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:441:7: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN257=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause2354); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN257_tree = (CommonTree)adaptor.dupNode(JOIN257);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN257_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause2356);
            join_sub_clause258=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause258.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:441:31: ( join_type )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==QUOTEDSTRING) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:441:31: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause2358);
                    join_type259=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type259.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:441:42: ( partition_clause )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==PARTITION) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:441:42: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause2361);
                    partition_clause260=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause260.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:444:1: join_type : QUOTEDSTRING ;
    public final AliasMasker.join_type_return join_type() throws RecognitionException {
        AliasMasker.join_type_return retval = new AliasMasker.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING261=null;

        CommonTree QUOTEDSTRING261_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:444:11: ( QUOTEDSTRING )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:444:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING261=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type2373); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING261_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING261);


            adaptor.addChild(root_0, QUOTEDSTRING261_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_type"


    public static class join_sub_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_sub_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:447:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final AliasMasker.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AliasMasker.join_sub_clause_return retval = new AliasMasker.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set263=null;
        CommonTree OUTER264=null;
        AliasMasker.join_item_return join_item262 =null;

        AliasMasker.join_item_return join_item265 =null;

        AliasMasker.join_item_return join_item266 =null;


        CommonTree set263_tree=null;
        CommonTree OUTER264_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:448:5: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==JOIN_ITEM) ) {
                int LA81_1 = input.LA(2);

                if ( (synpred147_AliasMasker()) ) {
                    alt81=1;
                }
                else if ( (true) ) {
                    alt81=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 81, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;

            }
            switch (alt81) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:448:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2386);
                    join_item262=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item262.getTree());


                    _last = (CommonTree)input.LT(1);
                    set263=(CommonTree)input.LT(1);

                    if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set263_tree = (CommonTree)adaptor.dupNode(set263);


                        adaptor.addChild(root_0, set263_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:451:16: ( OUTER )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==OUTER) ) {
                        alt79=1;
                    }
                    switch (alt79) {
                        case 1 :
                            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:451:16: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER264=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause2444); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER264_tree = (CommonTree)adaptor.dupNode(OUTER264);


                            adaptor.addChild(root_0, OUTER264_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2447);
                    join_item265=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item265.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:452:7: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:452:7: ( join_item )+
                    int cnt80=0;
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==JOIN_ITEM) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:452:7: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause2455);
                    	    join_item266=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item266.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt80 >= 1 ) break loop80;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(80, input);
                                throw eee;
                        }
                        cnt80++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_sub_clause"


    public static class join_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_item"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:455:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AliasMasker.join_item_return join_item() throws RecognitionException {
        AliasMasker.join_item_return retval = new AliasMasker.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM267=null;
        AliasMasker.rel_return rel268 =null;

        AliasMasker.join_group_by_clause_return join_group_by_clause269 =null;


        CommonTree JOIN_ITEM267_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:456:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:456:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM267=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item2468); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM267_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM267);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM267_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item2470);
            rel268=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel268.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item2472);
            join_group_by_clause269=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause269.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:459:1: join_group_by_clause : ^( BY ( join_group_by_expr )+ ) ;
    public final AliasMasker.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AliasMasker.join_group_by_clause_return retval = new AliasMasker.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY270=null;
        AliasMasker.join_group_by_expr_return join_group_by_expr271 =null;


        CommonTree BY270_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:460:5: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:460:7: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY270=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause2489); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY270_tree = (CommonTree)adaptor.dupNode(BY270);


            root_1 = (CommonTree)adaptor.becomeRoot(BY270_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:460:13: ( join_group_by_expr )+
            int cnt82=0;
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==CUBE||LA82_0==DIV||LA82_0==DOLLARVAR||LA82_0==DOUBLENUMBER||LA82_0==FALSE||LA82_0==FLOATNUMBER||LA82_0==GROUP||LA82_0==INTEGER||LA82_0==LONGINTEGER||LA82_0==MINUS||LA82_0==PERCENT||LA82_0==PLUS||LA82_0==QUOTEDSTRING||LA82_0==STAR||LA82_0==TRUE||(LA82_0 >= BAG_VAL && LA82_0 <= BIN_EXPR)||(LA82_0 >= CAST_EXPR && LA82_0 <= EXPR_IN_PAREN)||LA82_0==FUNC_EVAL||LA82_0==IDENTIFIER||(LA82_0 >= MAP_VAL && LA82_0 <= NEG)||LA82_0==NULL||LA82_0==TUPLE_VAL) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:460:13: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause2491);
            	    join_group_by_expr271=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr271.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt82 >= 1 ) break loop82;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(82, input);
                        throw eee;
                }
                cnt82++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_clause"


    public static class join_group_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:463:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AliasMasker.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AliasMasker.join_group_by_expr_return retval = new AliasMasker.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR274=null;
        AliasMasker.col_range_return col_range272 =null;

        AliasMasker.expr_return expr273 =null;


        CommonTree STAR274_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:464:5: ( col_range | expr | STAR )
            int alt83=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt83=1;
                }
                break;
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case IDENTIFIER:
            case MAP_VAL:
            case NEG:
            case NULL:
            case TUPLE_VAL:
                {
                alt83=2;
                }
                break;
            case STAR:
                {
                int LA83_3 = input.LA(2);

                if ( (LA83_3==DOWN) ) {
                    alt83=2;
                }
                else if ( (LA83_3==EOF||LA83_3==UP||LA83_3==CUBE||LA83_3==DIV||LA83_3==DOLLARVAR||LA83_3==DOUBLENUMBER||LA83_3==FALSE||LA83_3==FLOATNUMBER||LA83_3==GROUP||LA83_3==INTEGER||LA83_3==LONGINTEGER||LA83_3==MINUS||LA83_3==PERCENT||LA83_3==PLUS||LA83_3==QUOTEDSTRING||LA83_3==STAR||LA83_3==TRUE||(LA83_3 >= BAG_VAL && LA83_3 <= BIN_EXPR)||(LA83_3 >= CAST_EXPR && LA83_3 <= EXPR_IN_PAREN)||LA83_3==FUNC_EVAL||LA83_3==IDENTIFIER||(LA83_3 >= MAP_VAL && LA83_3 <= NEG)||LA83_3==NULL||LA83_3==TUPLE_VAL) ) {
                    alt83=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;

            }

            switch (alt83) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:464:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr2508);
                    col_range272=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range272.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:464:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr2512);
                    expr273=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr273.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:464:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR274=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr2516); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR274_tree = (CommonTree)adaptor.dupNode(STAR274);


                    adaptor.addChild(root_0, STAR274_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_expr"


    public static class union_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:467:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AliasMasker.union_clause_return union_clause() throws RecognitionException {
        AliasMasker.union_clause_return retval = new AliasMasker.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION275=null;
        CommonTree ONSCHEMA276=null;
        AliasMasker.rel_list_return rel_list277 =null;


        CommonTree UNION275_tree=null;
        CommonTree ONSCHEMA276_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:468:5: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:468:7: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION275=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause2533); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION275_tree = (CommonTree)adaptor.dupNode(UNION275);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION275_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:468:16: ( ONSCHEMA )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==ONSCHEMA) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:468:16: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA276=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause2535); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA276_tree = (CommonTree)adaptor.dupNode(ONSCHEMA276);


                    adaptor.addChild(root_1, ONSCHEMA276_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause2538);
            rel_list277=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list277.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "union_clause"


    public static class foreach_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:471:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AliasMasker.foreach_clause_return foreach_clause() throws RecognitionException {
        AliasMasker.foreach_clause_return retval = new AliasMasker.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH278=null;
        AliasMasker.rel_return rel279 =null;

        AliasMasker.foreach_plan_return foreach_plan280 =null;


        CommonTree FOREACH278_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:472:5: ( ^( FOREACH rel foreach_plan ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:472:7: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH278=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause2560); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH278_tree = (CommonTree)adaptor.dupNode(FOREACH278);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH278_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause2562);
            rel279=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel279.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause2564);
            foreach_plan280=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan280.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "foreach_clause"


    public static class foreach_plan_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_plan"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:475:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AliasMasker.foreach_plan_return foreach_plan() throws RecognitionException {
        AliasMasker.foreach_plan_return retval = new AliasMasker.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE281=null;
        CommonTree FOREACH_PLAN_COMPLEX283=null;
        AliasMasker.generate_clause_return generate_clause282 =null;

        AliasMasker.nested_blk_return nested_blk284 =null;


        CommonTree FOREACH_PLAN_SIMPLE281_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX283_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:476:5: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==FOREACH_PLAN_SIMPLE) ) {
                alt85=1;
            }
            else if ( (LA85_0==FOREACH_PLAN_COMPLEX) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;

            }
            switch (alt85) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:476:7: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE281=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2586); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE281_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE281);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE281_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan2588);
                    generate_clause282=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause282.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:477:7: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX283=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2600); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX283_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX283);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX283_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan2602);
                    nested_blk284=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk284.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "foreach_plan"


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:480:1: nested_blk : ( nested_command )* generate_clause ;
    public final AliasMasker.nested_blk_return nested_blk() throws RecognitionException {
        AliasMasker.nested_blk_return retval = new AliasMasker.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_command_return nested_command285 =null;

        AliasMasker.generate_clause_return generate_clause286 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:481:5: ( ( nested_command )* generate_clause )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:481:7: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:481:7: ( nested_command )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( ((LA86_0 >= NESTED_CMD && LA86_0 <= NESTED_CMD_ASSI)) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:481:7: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk2617);
            	    nested_command285=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command285.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk2620);
            generate_clause286=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause286.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_blk"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:484:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final AliasMasker.generate_clause_return generate_clause() throws RecognitionException {
        AliasMasker.generate_clause_return retval = new AliasMasker.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE287=null;
        AliasMasker.flatten_generated_item_return flatten_generated_item288 =null;


        CommonTree GENERATE287_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:485:5: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:485:7: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE287=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause2636); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE287_tree = (CommonTree)adaptor.dupNode(GENERATE287);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE287_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:485:19: ( flatten_generated_item )+
            int cnt87=0;
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==CUBE||LA87_0==DIV||LA87_0==DOLLARVAR||LA87_0==DOUBLENUMBER||LA87_0==FALSE||LA87_0==FLATTEN||LA87_0==FLOATNUMBER||LA87_0==GROUP||LA87_0==INTEGER||LA87_0==LONGINTEGER||LA87_0==MINUS||LA87_0==PERCENT||LA87_0==PLUS||LA87_0==QUOTEDSTRING||LA87_0==STAR||LA87_0==TRUE||(LA87_0 >= BAG_VAL && LA87_0 <= BIN_EXPR)||(LA87_0 >= CAST_EXPR && LA87_0 <= EXPR_IN_PAREN)||LA87_0==FUNC_EVAL||LA87_0==IDENTIFIER||(LA87_0 >= MAP_VAL && LA87_0 <= NEG)||LA87_0==NULL||LA87_0==TUPLE_VAL) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:485:19: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause2638);
            	    flatten_generated_item288=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item288.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt87 >= 1 ) break loop87;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(87, input);
                        throw eee;
                }
                cnt87++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "generate_clause"


    public static class nested_command_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_command"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:488:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AliasMasker.nested_command_return nested_command() throws RecognitionException {
        AliasMasker.nested_command_return retval = new AliasMasker.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD289=null;
        CommonTree IDENTIFIER290=null;
        CommonTree NESTED_CMD_ASSI292=null;
        CommonTree IDENTIFIER293=null;
        AliasMasker.nested_op_return nested_op291 =null;

        AliasMasker.expr_return expr294 =null;


        CommonTree NESTED_CMD289_tree=null;
        CommonTree IDENTIFIER290_tree=null;
        CommonTree NESTED_CMD_ASSI292_tree=null;
        CommonTree IDENTIFIER293_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:489:5: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==NESTED_CMD) ) {
                alt88=1;
            }
            else if ( (LA88_0==NESTED_CMD_ASSI) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;

            }
            switch (alt88) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:489:7: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD289=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command2660); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD289_tree = (CommonTree)adaptor.dupNode(NESTED_CMD289);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD289_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER290=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2662); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER290_tree = (CommonTree)adaptor.dupNode(IDENTIFIER290);


                    adaptor.addChild(root_1, IDENTIFIER290_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command2664);
                    nested_op291=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op291.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:490:7: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI292=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command2676); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI292_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI292);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI292_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER293=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2678); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER293_tree = (CommonTree)adaptor.dupNode(IDENTIFIER293);


                    adaptor.addChild(root_1, IDENTIFIER293_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command2680);
                    expr294=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr294.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_command"


    public static class nested_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:493:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AliasMasker.nested_op_return nested_op() throws RecognitionException {
        AliasMasker.nested_op_return retval = new AliasMasker.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_proj_return nested_proj295 =null;

        AliasMasker.nested_filter_return nested_filter296 =null;

        AliasMasker.nested_sort_return nested_sort297 =null;

        AliasMasker.nested_distinct_return nested_distinct298 =null;

        AliasMasker.nested_limit_return nested_limit299 =null;

        AliasMasker.nested_cross_return nested_cross300 =null;

        AliasMasker.nested_foreach_return nested_foreach301 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:493:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt89=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt89=1;
                }
                break;
            case FILTER:
                {
                alt89=2;
                }
                break;
            case ORDER:
                {
                alt89=3;
                }
                break;
            case DISTINCT:
                {
                alt89=4;
                }
                break;
            case LIMIT:
                {
                alt89=5;
                }
                break;
            case CROSS:
                {
                alt89=6;
                }
                break;
            case FOREACH:
                {
                alt89=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;

            }

            switch (alt89) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:493:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op2691);
                    nested_proj295=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj295.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:494:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op2705);
                    nested_filter296=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter296.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:495:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op2719);
                    nested_sort297=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort297.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:496:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op2733);
                    nested_distinct298=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct298.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:497:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op2747);
                    nested_limit299=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit299.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:498:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op2761);
                    nested_cross300=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross300.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:499:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op2775);
                    nested_foreach301=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach301.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op"


    public static class nested_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_proj"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:502:1: nested_proj : ^( NESTED_PROJ col_ref ( col_ref )+ ) ;
    public final AliasMasker.nested_proj_return nested_proj() throws RecognitionException {
        AliasMasker.nested_proj_return retval = new AliasMasker.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ302=null;
        AliasMasker.col_ref_return col_ref303 =null;

        AliasMasker.col_ref_return col_ref304 =null;


        CommonTree NESTED_PROJ302_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:503:5: ( ^( NESTED_PROJ col_ref ( col_ref )+ ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:503:7: ^( NESTED_PROJ col_ref ( col_ref )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ302=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj2791); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ302_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ302);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ302_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj2793);
            col_ref303=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref303.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:503:30: ( col_ref )+
            int cnt90=0;
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==CUBE||LA90_0==DOLLARVAR||LA90_0==GROUP||LA90_0==IDENTIFIER) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:503:30: col_ref
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj2795);
            	    col_ref304=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref304.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt90 >= 1 ) break loop90;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(90, input);
                        throw eee;
                }
                cnt90++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_proj"


    public static class nested_filter_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:506:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AliasMasker.nested_filter_return nested_filter() throws RecognitionException {
        AliasMasker.nested_filter_return retval = new AliasMasker.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER305=null;
        AliasMasker.nested_op_input_return nested_op_input306 =null;

        AliasMasker.cond_return cond307 =null;


        CommonTree FILTER305_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:507:5: ( ^( FILTER nested_op_input cond ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:507:7: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER305=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter2817); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER305_tree = (CommonTree)adaptor.dupNode(FILTER305);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER305_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter2819);
            nested_op_input306=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input306.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter2821);
            cond307=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond307.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_filter"


    public static class nested_sort_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_sort"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:510:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AliasMasker.nested_sort_return nested_sort() throws RecognitionException {
        AliasMasker.nested_sort_return retval = new AliasMasker.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER308=null;
        AliasMasker.nested_op_input_return nested_op_input309 =null;

        AliasMasker.order_by_clause_return order_by_clause310 =null;

        AliasMasker.func_clause_return func_clause311 =null;


        CommonTree ORDER308_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:511:5: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:511:7: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER308=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort2843); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER308_tree = (CommonTree)adaptor.dupNode(ORDER308);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER308_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort2845);
            nested_op_input309=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input309.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort2847);
            order_by_clause310=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause310.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:511:48: ( func_clause )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==FUNC||LA91_0==FUNC_REF) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:511:48: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort2849);
                    func_clause311=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause311.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_sort"


    public static class nested_distinct_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_distinct"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:514:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AliasMasker.nested_distinct_return nested_distinct() throws RecognitionException {
        AliasMasker.nested_distinct_return retval = new AliasMasker.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT312=null;
        AliasMasker.nested_op_input_return nested_op_input313 =null;


        CommonTree DISTINCT312_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:515:5: ( ^( DISTINCT nested_op_input ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:515:7: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT312=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct2872); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT312_tree = (CommonTree)adaptor.dupNode(DISTINCT312);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT312_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct2874);
            nested_op_input313=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input313.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_distinct"


    public static class nested_limit_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_limit"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:518:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AliasMasker.nested_limit_return nested_limit() throws RecognitionException {
        AliasMasker.nested_limit_return retval = new AliasMasker.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT314=null;
        CommonTree INTEGER316=null;
        AliasMasker.nested_op_input_return nested_op_input315 =null;

        AliasMasker.expr_return expr317 =null;


        CommonTree LIMIT314_tree=null;
        CommonTree INTEGER316_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:519:5: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:519:7: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT314=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit2896); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT314_tree = (CommonTree)adaptor.dupNode(LIMIT314);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT314_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit2898);
            nested_op_input315=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input315.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:519:32: ( INTEGER | expr )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==INTEGER) ) {
                int LA92_1 = input.LA(2);

                if ( (synpred165_AliasMasker()) ) {
                    alt92=1;
                }
                else if ( (true) ) {
                    alt92=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 92, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA92_0==CUBE||LA92_0==DIV||LA92_0==DOLLARVAR||LA92_0==DOUBLENUMBER||LA92_0==FALSE||LA92_0==FLOATNUMBER||LA92_0==GROUP||LA92_0==LONGINTEGER||LA92_0==MINUS||LA92_0==PERCENT||LA92_0==PLUS||LA92_0==QUOTEDSTRING||LA92_0==STAR||LA92_0==TRUE||(LA92_0 >= BAG_VAL && LA92_0 <= BIN_EXPR)||LA92_0==CAST_EXPR||LA92_0==EXPR_IN_PAREN||LA92_0==FUNC_EVAL||LA92_0==IDENTIFIER||(LA92_0 >= MAP_VAL && LA92_0 <= NEG)||LA92_0==NULL||LA92_0==TUPLE_VAL) ) {
                alt92=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;

            }
            switch (alt92) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:519:34: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER316=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit2902); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER316_tree = (CommonTree)adaptor.dupNode(INTEGER316);


                    adaptor.addChild(root_1, INTEGER316_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:519:44: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit2906);
                    expr317=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr317.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_limit"


    public static class nested_cross_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_cross"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:522:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AliasMasker.nested_cross_return nested_cross() throws RecognitionException {
        AliasMasker.nested_cross_return retval = new AliasMasker.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS318=null;
        AliasMasker.nested_op_input_list_return nested_op_input_list319 =null;


        CommonTree CROSS318_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:522:14: ( ^( CROSS nested_op_input_list ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:522:16: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS318=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross2921); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS318_tree = (CommonTree)adaptor.dupNode(CROSS318);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS318_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross2923);
            nested_op_input_list319=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list319.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_cross"


    public static class nested_foreach_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_foreach"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:525:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AliasMasker.nested_foreach_return nested_foreach() throws RecognitionException {
        AliasMasker.nested_foreach_return retval = new AliasMasker.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH320=null;
        AliasMasker.nested_op_input_return nested_op_input321 =null;

        AliasMasker.generate_clause_return generate_clause322 =null;


        CommonTree FOREACH320_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:525:16: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:525:18: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH320=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach2936); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH320_tree = (CommonTree)adaptor.dupNode(FOREACH320);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH320_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach2938);
            nested_op_input321=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input321.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach2940);
            generate_clause322=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause322.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_foreach"


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:528:1: nested_op_input_list : ( nested_op_input )+ ;
    public final AliasMasker.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AliasMasker.nested_op_input_list_return retval = new AliasMasker.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_op_input_return nested_op_input323 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:528:22: ( ( nested_op_input )+ )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:528:24: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:528:24: ( nested_op_input )+
            int cnt93=0;
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==CUBE||LA93_0==DOLLARVAR||LA93_0==GROUP||LA93_0==IDENTIFIER||LA93_0==NESTED_PROJ) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:528:24: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list2951);
            	    nested_op_input323=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input323.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt93 >= 1 ) break loop93;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(93, input);
                        throw eee;
                }
                cnt93++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input_list"


    public static class nested_op_input_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:531:1: nested_op_input : ( col_ref | nested_proj );
    public final AliasMasker.nested_op_input_return nested_op_input() throws RecognitionException {
        AliasMasker.nested_op_input_return retval = new AliasMasker.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.col_ref_return col_ref324 =null;

        AliasMasker.nested_proj_return nested_proj325 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:531:17: ( col_ref | nested_proj )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==CUBE||LA94_0==DOLLARVAR||LA94_0==GROUP||LA94_0==IDENTIFIER) ) {
                alt94=1;
            }
            else if ( (LA94_0==NESTED_PROJ) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;

            }
            switch (alt94) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:531:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input2961);
                    col_ref324=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref324.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:531:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input2965);
                    nested_proj325=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj325.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input"


    public static class stream_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:534:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AliasMasker.stream_clause_return stream_clause() throws RecognitionException {
        AliasMasker.stream_clause_return retval = new AliasMasker.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM326=null;
        CommonTree set328=null;
        AliasMasker.rel_return rel327 =null;

        AliasMasker.as_clause_return as_clause329 =null;


        CommonTree STREAM326_tree=null;
        CommonTree set328_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:535:5: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:535:7: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM326=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause2981); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM326_tree = (CommonTree)adaptor.dupNode(STREAM326);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM326_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause2983);
            rel327=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel327.getTree());


            _last = (CommonTree)input.LT(1);
            set328=(CommonTree)input.LT(1);

            if ( input.LA(1)==EXECCOMMAND||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set328_tree = (CommonTree)adaptor.dupNode(set328);


                adaptor.addChild(root_1, set328_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:535:50: ( as_clause )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==AS) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:535:50: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause2995);
                    as_clause329=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause329.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_clause"


    public static class mr_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mr_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:538:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AliasMasker.mr_clause_return mr_clause() throws RecognitionException {
        AliasMasker.mr_clause_return retval = new AliasMasker.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE330=null;
        CommonTree QUOTEDSTRING331=null;
        CommonTree EXECCOMMAND335=null;
        AliasMasker.path_list_return path_list332 =null;

        AliasMasker.store_clause_return store_clause333 =null;

        AliasMasker.load_clause_return load_clause334 =null;


        CommonTree MAPREDUCE330_tree=null;
        CommonTree QUOTEDSTRING331_tree=null;
        CommonTree EXECCOMMAND335_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:539:5: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:539:7: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE330=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause3014); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE330_tree = (CommonTree)adaptor.dupNode(MAPREDUCE330);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE330_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING331=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause3016); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING331_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING331);


            adaptor.addChild(root_1, QUOTEDSTRING331_tree);
            }


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:539:33: ( path_list )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==QUOTEDSTRING) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:539:33: path_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause3018);
                    path_list332=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list332.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause3021);
            store_clause333=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause333.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause3023);
            load_clause334=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause334.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:539:69: ( EXECCOMMAND )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==EXECCOMMAND) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:539:69: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND335=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause3025); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND335_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND335);


                    adaptor.addChild(root_1, EXECCOMMAND335_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "mr_clause"


    public static class split_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_clause"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:542:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final AliasMasker.split_clause_return split_clause() throws RecognitionException {
        AliasMasker.split_clause_return retval = new AliasMasker.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT336=null;
        AliasMasker.rel_return rel337 =null;

        AliasMasker.split_branch_return split_branch338 =null;

        AliasMasker.split_otherwise_return split_otherwise339 =null;


        CommonTree SPLIT336_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:543:5: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:543:7: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT336=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause3044); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT336_tree = (CommonTree)adaptor.dupNode(SPLIT336);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT336_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause3046);
            rel337=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel337.getTree());


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:543:20: ( split_branch )+
            int cnt98=0;
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==SPLIT_BRANCH) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:543:20: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause3048);
            	    split_branch338=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch338.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt98 >= 1 ) break loop98;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(98, input);
                        throw eee;
                }
                cnt98++;
            } while (true);


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:543:34: ( split_otherwise )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==OTHERWISE) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:543:34: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause3051);
                    split_otherwise339=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise339.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_clause"


    public static class split_branch_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_branch"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:546:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AliasMasker.split_branch_return split_branch() throws RecognitionException {
        AliasMasker.split_branch_return retval = new AliasMasker.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH340=null;
        AliasMasker.alias_return alias341 =null;

        AliasMasker.cond_return cond342 =null;


        CommonTree SPLIT_BRANCH340_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:547:5: ( ^( SPLIT_BRANCH alias cond ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:547:7: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH340=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch3069); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH340_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH340);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH340_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch3071);
            alias341=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias341.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch3073);
            cond342=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond342.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_branch"


    public static class split_otherwise_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_otherwise"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:550:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AliasMasker.split_otherwise_return split_otherwise() throws RecognitionException {
        AliasMasker.split_otherwise_return retval = new AliasMasker.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE343=null;
        AliasMasker.alias_return alias344 =null;


        CommonTree OTHERWISE343_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:551:5: ( ^( OTHERWISE alias ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:551:7: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE343=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise3091); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE343_tree = (CommonTree)adaptor.dupNode(OTHERWISE343);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE343_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise3093);
            alias344=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias344.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_otherwise"


    public static class col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_ref"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:554:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AliasMasker.col_ref_return col_ref() throws RecognitionException {
        AliasMasker.col_ref_return retval = new AliasMasker.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.alias_col_ref_return alias_col_ref345 =null;

        AliasMasker.dollar_col_ref_return dollar_col_ref346 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:554:9: ( alias_col_ref | dollar_col_ref )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==CUBE||LA100_0==GROUP||LA100_0==IDENTIFIER) ) {
                alt100=1;
            }
            else if ( (LA100_0==DOLLARVAR) ) {
                alt100=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;

            }
            switch (alt100) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:554:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref3105);
                    alias_col_ref345=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref345.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:554:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref3109);
                    dollar_col_ref346=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref346.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_ref"


    public static class alias_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias_col_ref"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:557:1: alias_col_ref : ( GROUP | CUBE | IDENTIFIER );
    public final AliasMasker.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AliasMasker.alias_col_ref_return retval = new AliasMasker.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP347=null;
        CommonTree CUBE348=null;
        CommonTree IDENTIFIER349=null;

        CommonTree GROUP347_tree=null;
        CommonTree CUBE348_tree=null;
        CommonTree IDENTIFIER349_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:558:5: ( GROUP | CUBE | IDENTIFIER )
            int alt101=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt101=1;
                }
                break;
            case CUBE:
                {
                alt101=2;
                }
                break;
            case IDENTIFIER:
                {
                alt101=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;

            }

            switch (alt101) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:558:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP347=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref3123); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP347_tree = (CommonTree)adaptor.dupNode(GROUP347);


                    adaptor.addChild(root_0, GROUP347_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:559:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE348=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref3132); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE348_tree = (CommonTree)adaptor.dupNode(CUBE348);


                    adaptor.addChild(root_0, CUBE348_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:560:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER349=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref3140); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER349_tree = (CommonTree)adaptor.dupNode(IDENTIFIER349);


                    adaptor.addChild(root_0, IDENTIFIER349_tree);
                    }


                    if ( state.backtracking==0 ) {
                              String alias = (IDENTIFIER349!=null?IDENTIFIER349.getText():null);
                              String[] names = alias.split( "::" );
                              StringBuilder sb = new StringBuilder();
                              for( int i = 0; i < names.length; i++ ) {
                                  String name = names[i];
                                  sb.append( aliasSeen.contains( name ) ? getMask( name ) : name );
                                  if( i < names.length - 1 )
                                      sb.append( "::" );
                              }
                              IDENTIFIER349.token.setText( sb.toString() );
                          }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:575:1: dollar_col_ref : DOLLARVAR ;
    public final AliasMasker.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AliasMasker.dollar_col_ref_return retval = new AliasMasker.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR350=null;

        CommonTree DOLLARVAR350_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:576:5: ( DOLLARVAR )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:576:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR350=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref3162); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR350_tree = (CommonTree)adaptor.dupNode(DOLLARVAR350);


            adaptor.addChild(root_0, DOLLARVAR350_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dollar_col_ref"


    public static class const_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:579:1: const_expr : literal ;
    public final AliasMasker.const_expr_return const_expr() throws RecognitionException {
        AliasMasker.const_expr_return retval = new AliasMasker.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.literal_return literal351 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:579:12: ( literal )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:579:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr3171);
            literal351=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal351.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "const_expr"


    public static class literal_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:582:1: literal : ( scalar | map | bag | tuple );
    public final AliasMasker.literal_return literal() throws RecognitionException {
        AliasMasker.literal_return retval = new AliasMasker.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.scalar_return scalar352 =null;

        AliasMasker.map_return map353 =null;

        AliasMasker.bag_return bag354 =null;

        AliasMasker.tuple_return tuple355 =null;



        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:582:9: ( scalar | map | bag | tuple )
            int alt102=4;
            switch ( input.LA(1) ) {
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case QUOTEDSTRING:
            case TRUE:
            case NULL:
                {
                alt102=1;
                }
                break;
            case MAP_VAL:
                {
                alt102=2;
                }
                break;
            case BAG_VAL:
                {
                alt102=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt102=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;

            }

            switch (alt102) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:582:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal3180);
                    scalar352=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar352.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:582:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal3184);
                    map353=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map353.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:582:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal3188);
                    bag354=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag354.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:582:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal3192);
                    tuple355=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple355.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal"


    public static class scalar_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scalar"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:585:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AliasMasker.scalar_return scalar() throws RecognitionException {
        AliasMasker.scalar_return retval = new AliasMasker.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING357=null;
        CommonTree NULL358=null;
        CommonTree TRUE359=null;
        CommonTree FALSE360=null;
        AliasMasker.num_scalar_return num_scalar356 =null;


        CommonTree QUOTEDSTRING357_tree=null;
        CommonTree NULL358_tree=null;
        CommonTree TRUE359_tree=null;
        CommonTree FALSE360_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:585:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt103=5;
            switch ( input.LA(1) ) {
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt103=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt103=2;
                }
                break;
            case NULL:
                {
                alt103=3;
                }
                break;
            case TRUE:
                {
                alt103=4;
                }
                break;
            case FALSE:
                {
                alt103=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;

            }

            switch (alt103) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:585:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar3201);
                    num_scalar356=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar356.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:585:23: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING357=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar3205); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING357_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING357);


                    adaptor.addChild(root_0, QUOTEDSTRING357_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:585:38: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL358=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar3209); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL358_tree = (CommonTree)adaptor.dupNode(NULL358);


                    adaptor.addChild(root_0, NULL358_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:585:45: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE359=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar3213); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE359_tree = (CommonTree)adaptor.dupNode(TRUE359);


                    adaptor.addChild(root_0, TRUE359_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:585:52: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE360=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar3217); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE360_tree = (CommonTree)adaptor.dupNode(FALSE360);


                    adaptor.addChild(root_0, FALSE360_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "scalar"


    public static class num_scalar_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:588:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER ) ;
    public final AliasMasker.num_scalar_return num_scalar() throws RecognitionException {
        AliasMasker.num_scalar_return retval = new AliasMasker.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS361=null;
        CommonTree set362=null;

        CommonTree MINUS361_tree=null;
        CommonTree set362_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:588:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:588:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:588:14: ( MINUS )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==MINUS) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:588:14: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS361=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar3226); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS361_tree = (CommonTree)adaptor.dupNode(MINUS361);


                    adaptor.addChild(root_0, MINUS361_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            set362=(CommonTree)input.LT(1);

            if ( input.LA(1)==DOUBLENUMBER||input.LA(1)==FLOATNUMBER||input.LA(1)==INTEGER||input.LA(1)==LONGINTEGER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set362_tree = (CommonTree)adaptor.dupNode(set362);


                adaptor.addChild(root_0, set362_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "num_scalar"


    public static class map_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:591:1: map : ^( MAP_VAL ( keyvalue )* ) ;
    public final AliasMasker.map_return map() throws RecognitionException {
        AliasMasker.map_return retval = new AliasMasker.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL363=null;
        AliasMasker.keyvalue_return keyvalue364 =null;


        CommonTree MAP_VAL363_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:592:5: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:592:7: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL363=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map3261); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL363_tree = (CommonTree)adaptor.dupNode(MAP_VAL363);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL363_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:592:18: ( keyvalue )*
                loop105:
                do {
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( (LA105_0==KEY_VAL_PAIR) ) {
                        alt105=1;
                    }


                    switch (alt105) {
                	case 1 :
                	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:592:18: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map3263);
                	    keyvalue364=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue364.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop105;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map"


    public static class keyvalue_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:595:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AliasMasker.keyvalue_return keyvalue() throws RecognitionException {
        AliasMasker.keyvalue_return retval = new AliasMasker.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR365=null;
        AliasMasker.map_key_return map_key366 =null;

        AliasMasker.const_expr_return const_expr367 =null;


        CommonTree KEY_VAL_PAIR365_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:596:5: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:596:7: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR365=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue3282); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR365_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR365);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR365_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue3284);
            map_key366=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key366.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue3286);
            const_expr367=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr367.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "keyvalue"


    public static class map_key_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_key"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:599:1: map_key : QUOTEDSTRING ;
    public final AliasMasker.map_key_return map_key() throws RecognitionException {
        AliasMasker.map_key_return retval = new AliasMasker.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING368=null;

        CommonTree QUOTEDSTRING368_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:599:9: ( QUOTEDSTRING )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:599:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING368=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key3301); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING368_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING368);


            adaptor.addChild(root_0, QUOTEDSTRING368_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_key"


    public static class bag_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:602:1: bag : ^( BAG_VAL ( tuple )* ) ;
    public final AliasMasker.bag_return bag() throws RecognitionException {
        AliasMasker.bag_return retval = new AliasMasker.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL369=null;
        AliasMasker.tuple_return tuple370 =null;


        CommonTree BAG_VAL369_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:603:5: ( ^( BAG_VAL ( tuple )* ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:603:7: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL369=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag3317); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL369_tree = (CommonTree)adaptor.dupNode(BAG_VAL369);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL369_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:603:18: ( tuple )*
                loop106:
                do {
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( (LA106_0==TUPLE_VAL) ) {
                        alt106=1;
                    }


                    switch (alt106) {
                	case 1 :
                	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:603:18: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag3319);
                	    tuple370=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple370.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop106;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag"


    public static class tuple_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:606:1: tuple : ^( TUPLE_VAL ( literal )* ) ;
    public final AliasMasker.tuple_return tuple() throws RecognitionException {
        AliasMasker.tuple_return retval = new AliasMasker.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL371=null;
        AliasMasker.literal_return literal372 =null;


        CommonTree TUPLE_VAL371_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:607:5: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:607:7: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL371=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple3338); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL371_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL371);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL371_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:607:20: ( literal )*
                loop107:
                do {
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( (LA107_0==DOUBLENUMBER||LA107_0==FALSE||LA107_0==FLOATNUMBER||LA107_0==INTEGER||LA107_0==LONGINTEGER||LA107_0==MINUS||LA107_0==QUOTEDSTRING||LA107_0==TRUE||LA107_0==BAG_VAL||LA107_0==MAP_VAL||LA107_0==NULL||LA107_0==TUPLE_VAL) ) {
                        alt107=1;
                    }


                    switch (alt107) {
                	case 1 :
                	    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:607:20: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple3340);
                	    literal372=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal372.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop107;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple"


    public static class eid_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:611:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE );
    public final AliasMasker.eid_return eid() throws RecognitionException {
        AliasMasker.eid_return retval = new AliasMasker.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT374=null;
        CommonTree RETURNS375=null;
        CommonTree DEFINE376=null;
        CommonTree LOAD377=null;
        CommonTree FILTER378=null;
        CommonTree FOREACH379=null;
        CommonTree CUBE380=null;
        CommonTree ROLLUP381=null;
        CommonTree MATCHES382=null;
        CommonTree ORDER383=null;
        CommonTree RANK384=null;
        CommonTree DISTINCT385=null;
        CommonTree COGROUP386=null;
        CommonTree JOIN387=null;
        CommonTree CROSS388=null;
        CommonTree UNION389=null;
        CommonTree SPLIT390=null;
        CommonTree INTO391=null;
        CommonTree IF392=null;
        CommonTree ALL393=null;
        CommonTree AS394=null;
        CommonTree BY395=null;
        CommonTree USING396=null;
        CommonTree INNER397=null;
        CommonTree OUTER398=null;
        CommonTree PARALLEL399=null;
        CommonTree PARTITION400=null;
        CommonTree GROUP401=null;
        CommonTree AND402=null;
        CommonTree OR403=null;
        CommonTree NOT404=null;
        CommonTree GENERATE405=null;
        CommonTree FLATTEN406=null;
        CommonTree EVAL407=null;
        CommonTree ASC408=null;
        CommonTree DESC409=null;
        CommonTree BOOLEAN410=null;
        CommonTree INT411=null;
        CommonTree LONG412=null;
        CommonTree FLOAT413=null;
        CommonTree DOUBLE414=null;
        CommonTree DATETIME415=null;
        CommonTree CHARARRAY416=null;
        CommonTree BYTEARRAY417=null;
        CommonTree BAG418=null;
        CommonTree TUPLE419=null;
        CommonTree MAP420=null;
        CommonTree IS421=null;
        CommonTree NULL422=null;
        CommonTree TRUE423=null;
        CommonTree FALSE424=null;
        CommonTree STREAM425=null;
        CommonTree THROUGH426=null;
        CommonTree STORE427=null;
        CommonTree MAPREDUCE428=null;
        CommonTree SHIP429=null;
        CommonTree CACHE430=null;
        CommonTree INPUT431=null;
        CommonTree OUTPUT432=null;
        CommonTree STDERROR433=null;
        CommonTree STDIN434=null;
        CommonTree STDOUT435=null;
        CommonTree LIMIT436=null;
        CommonTree SAMPLE437=null;
        CommonTree LEFT438=null;
        CommonTree RIGHT439=null;
        CommonTree FULL440=null;
        CommonTree IDENTIFIER441=null;
        CommonTree TOBAG442=null;
        CommonTree TOMAP443=null;
        CommonTree TOTUPLE444=null;
        AliasMasker.rel_str_op_return rel_str_op373 =null;


        CommonTree IMPORT374_tree=null;
        CommonTree RETURNS375_tree=null;
        CommonTree DEFINE376_tree=null;
        CommonTree LOAD377_tree=null;
        CommonTree FILTER378_tree=null;
        CommonTree FOREACH379_tree=null;
        CommonTree CUBE380_tree=null;
        CommonTree ROLLUP381_tree=null;
        CommonTree MATCHES382_tree=null;
        CommonTree ORDER383_tree=null;
        CommonTree RANK384_tree=null;
        CommonTree DISTINCT385_tree=null;
        CommonTree COGROUP386_tree=null;
        CommonTree JOIN387_tree=null;
        CommonTree CROSS388_tree=null;
        CommonTree UNION389_tree=null;
        CommonTree SPLIT390_tree=null;
        CommonTree INTO391_tree=null;
        CommonTree IF392_tree=null;
        CommonTree ALL393_tree=null;
        CommonTree AS394_tree=null;
        CommonTree BY395_tree=null;
        CommonTree USING396_tree=null;
        CommonTree INNER397_tree=null;
        CommonTree OUTER398_tree=null;
        CommonTree PARALLEL399_tree=null;
        CommonTree PARTITION400_tree=null;
        CommonTree GROUP401_tree=null;
        CommonTree AND402_tree=null;
        CommonTree OR403_tree=null;
        CommonTree NOT404_tree=null;
        CommonTree GENERATE405_tree=null;
        CommonTree FLATTEN406_tree=null;
        CommonTree EVAL407_tree=null;
        CommonTree ASC408_tree=null;
        CommonTree DESC409_tree=null;
        CommonTree BOOLEAN410_tree=null;
        CommonTree INT411_tree=null;
        CommonTree LONG412_tree=null;
        CommonTree FLOAT413_tree=null;
        CommonTree DOUBLE414_tree=null;
        CommonTree DATETIME415_tree=null;
        CommonTree CHARARRAY416_tree=null;
        CommonTree BYTEARRAY417_tree=null;
        CommonTree BAG418_tree=null;
        CommonTree TUPLE419_tree=null;
        CommonTree MAP420_tree=null;
        CommonTree IS421_tree=null;
        CommonTree NULL422_tree=null;
        CommonTree TRUE423_tree=null;
        CommonTree FALSE424_tree=null;
        CommonTree STREAM425_tree=null;
        CommonTree THROUGH426_tree=null;
        CommonTree STORE427_tree=null;
        CommonTree MAPREDUCE428_tree=null;
        CommonTree SHIP429_tree=null;
        CommonTree CACHE430_tree=null;
        CommonTree INPUT431_tree=null;
        CommonTree OUTPUT432_tree=null;
        CommonTree STDERROR433_tree=null;
        CommonTree STDIN434_tree=null;
        CommonTree STDOUT435_tree=null;
        CommonTree LIMIT436_tree=null;
        CommonTree SAMPLE437_tree=null;
        CommonTree LEFT438_tree=null;
        CommonTree RIGHT439_tree=null;
        CommonTree FULL440_tree=null;
        CommonTree IDENTIFIER441_tree=null;
        CommonTree TOBAG442_tree=null;
        CommonTree TOMAP443_tree=null;
        CommonTree TOTUPLE444_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:611:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE )
            int alt108=72;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt108=1;
                }
                break;
            case IMPORT:
                {
                alt108=2;
                }
                break;
            case RETURNS:
                {
                alt108=3;
                }
                break;
            case DEFINE:
                {
                alt108=4;
                }
                break;
            case LOAD:
                {
                alt108=5;
                }
                break;
            case FILTER:
                {
                alt108=6;
                }
                break;
            case FOREACH:
                {
                alt108=7;
                }
                break;
            case CUBE:
                {
                alt108=8;
                }
                break;
            case ROLLUP:
                {
                alt108=9;
                }
                break;
            case MATCHES:
                {
                alt108=10;
                }
                break;
            case ORDER:
                {
                alt108=11;
                }
                break;
            case RANK:
                {
                alt108=12;
                }
                break;
            case DISTINCT:
                {
                alt108=13;
                }
                break;
            case COGROUP:
                {
                alt108=14;
                }
                break;
            case JOIN:
                {
                alt108=15;
                }
                break;
            case CROSS:
                {
                alt108=16;
                }
                break;
            case UNION:
                {
                alt108=17;
                }
                break;
            case SPLIT:
                {
                alt108=18;
                }
                break;
            case INTO:
                {
                alt108=19;
                }
                break;
            case IF:
                {
                alt108=20;
                }
                break;
            case ALL:
                {
                alt108=21;
                }
                break;
            case AS:
                {
                alt108=22;
                }
                break;
            case BY:
                {
                alt108=23;
                }
                break;
            case USING:
                {
                alt108=24;
                }
                break;
            case INNER:
                {
                alt108=25;
                }
                break;
            case OUTER:
                {
                alt108=26;
                }
                break;
            case PARALLEL:
                {
                alt108=27;
                }
                break;
            case PARTITION:
                {
                alt108=28;
                }
                break;
            case GROUP:
                {
                alt108=29;
                }
                break;
            case AND:
                {
                alt108=30;
                }
                break;
            case OR:
                {
                alt108=31;
                }
                break;
            case NOT:
                {
                alt108=32;
                }
                break;
            case GENERATE:
                {
                alt108=33;
                }
                break;
            case FLATTEN:
                {
                alt108=34;
                }
                break;
            case EVAL:
                {
                alt108=35;
                }
                break;
            case ASC:
                {
                alt108=36;
                }
                break;
            case DESC:
                {
                alt108=37;
                }
                break;
            case BOOLEAN:
                {
                alt108=38;
                }
                break;
            case INT:
                {
                alt108=39;
                }
                break;
            case LONG:
                {
                alt108=40;
                }
                break;
            case FLOAT:
                {
                alt108=41;
                }
                break;
            case DOUBLE:
                {
                alt108=42;
                }
                break;
            case DATETIME:
                {
                alt108=43;
                }
                break;
            case CHARARRAY:
                {
                alt108=44;
                }
                break;
            case BYTEARRAY:
                {
                alt108=45;
                }
                break;
            case BAG:
                {
                alt108=46;
                }
                break;
            case TUPLE:
                {
                alt108=47;
                }
                break;
            case MAP:
                {
                alt108=48;
                }
                break;
            case IS:
                {
                alt108=49;
                }
                break;
            case NULL:
                {
                alt108=50;
                }
                break;
            case TRUE:
                {
                alt108=51;
                }
                break;
            case FALSE:
                {
                alt108=52;
                }
                break;
            case STREAM:
                {
                alt108=53;
                }
                break;
            case THROUGH:
                {
                alt108=54;
                }
                break;
            case STORE:
                {
                alt108=55;
                }
                break;
            case MAPREDUCE:
                {
                alt108=56;
                }
                break;
            case SHIP:
                {
                alt108=57;
                }
                break;
            case CACHE:
                {
                alt108=58;
                }
                break;
            case INPUT:
                {
                alt108=59;
                }
                break;
            case OUTPUT:
                {
                alt108=60;
                }
                break;
            case STDERROR:
                {
                alt108=61;
                }
                break;
            case STDIN:
                {
                alt108=62;
                }
                break;
            case STDOUT:
                {
                alt108=63;
                }
                break;
            case LIMIT:
                {
                alt108=64;
                }
                break;
            case SAMPLE:
                {
                alt108=65;
                }
                break;
            case LEFT:
                {
                alt108=66;
                }
                break;
            case RIGHT:
                {
                alt108=67;
                }
                break;
            case FULL:
                {
                alt108=68;
                }
                break;
            case IDENTIFIER:
                {
                alt108=69;
                }
                break;
            case TOBAG:
                {
                alt108=70;
                }
                break;
            case TOMAP:
                {
                alt108=71;
                }
                break;
            case TOTUPLE:
                {
                alt108=72;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;

            }

            switch (alt108) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:611:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid3353);
                    rel_str_op373=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op373.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:612:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT374=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid3361); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT374_tree = (CommonTree)adaptor.dupNode(IMPORT374);


                    adaptor.addChild(root_0, IMPORT374_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:613:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS375=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid3369); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS375_tree = (CommonTree)adaptor.dupNode(RETURNS375);


                    adaptor.addChild(root_0, RETURNS375_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:614:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE376=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid3377); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE376_tree = (CommonTree)adaptor.dupNode(DEFINE376);


                    adaptor.addChild(root_0, DEFINE376_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:615:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD377=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid3385); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD377_tree = (CommonTree)adaptor.dupNode(LOAD377);


                    adaptor.addChild(root_0, LOAD377_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:616:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER378=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid3393); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER378_tree = (CommonTree)adaptor.dupNode(FILTER378);


                    adaptor.addChild(root_0, FILTER378_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:617:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH379=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid3401); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH379_tree = (CommonTree)adaptor.dupNode(FOREACH379);


                    adaptor.addChild(root_0, FOREACH379_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:618:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE380=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid3409); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE380_tree = (CommonTree)adaptor.dupNode(CUBE380);


                    adaptor.addChild(root_0, CUBE380_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:619:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP381=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid3417); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP381_tree = (CommonTree)adaptor.dupNode(ROLLUP381);


                    adaptor.addChild(root_0, ROLLUP381_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:620:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES382=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid3425); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES382_tree = (CommonTree)adaptor.dupNode(MATCHES382);


                    adaptor.addChild(root_0, MATCHES382_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:621:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER383=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid3433); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER383_tree = (CommonTree)adaptor.dupNode(ORDER383);


                    adaptor.addChild(root_0, ORDER383_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:622:7: RANK
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RANK384=(CommonTree)match(input,RANK,FOLLOW_RANK_in_eid3441); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RANK384_tree = (CommonTree)adaptor.dupNode(RANK384);


                    adaptor.addChild(root_0, RANK384_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:623:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT385=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid3449); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT385_tree = (CommonTree)adaptor.dupNode(DISTINCT385);


                    adaptor.addChild(root_0, DISTINCT385_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:624:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP386=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid3457); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP386_tree = (CommonTree)adaptor.dupNode(COGROUP386);


                    adaptor.addChild(root_0, COGROUP386_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:625:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN387=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid3465); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN387_tree = (CommonTree)adaptor.dupNode(JOIN387);


                    adaptor.addChild(root_0, JOIN387_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:626:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS388=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid3473); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS388_tree = (CommonTree)adaptor.dupNode(CROSS388);


                    adaptor.addChild(root_0, CROSS388_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:627:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION389=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid3481); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION389_tree = (CommonTree)adaptor.dupNode(UNION389);


                    adaptor.addChild(root_0, UNION389_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:628:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT390=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid3489); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT390_tree = (CommonTree)adaptor.dupNode(SPLIT390);


                    adaptor.addChild(root_0, SPLIT390_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:629:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO391=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid3497); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO391_tree = (CommonTree)adaptor.dupNode(INTO391);


                    adaptor.addChild(root_0, INTO391_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:630:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF392=(CommonTree)match(input,IF,FOLLOW_IF_in_eid3505); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF392_tree = (CommonTree)adaptor.dupNode(IF392);


                    adaptor.addChild(root_0, IF392_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:631:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL393=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid3513); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL393_tree = (CommonTree)adaptor.dupNode(ALL393);


                    adaptor.addChild(root_0, ALL393_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:632:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS394=(CommonTree)match(input,AS,FOLLOW_AS_in_eid3521); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS394_tree = (CommonTree)adaptor.dupNode(AS394);


                    adaptor.addChild(root_0, AS394_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:633:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY395=(CommonTree)match(input,BY,FOLLOW_BY_in_eid3529); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY395_tree = (CommonTree)adaptor.dupNode(BY395);


                    adaptor.addChild(root_0, BY395_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:634:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING396=(CommonTree)match(input,USING,FOLLOW_USING_in_eid3537); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING396_tree = (CommonTree)adaptor.dupNode(USING396);


                    adaptor.addChild(root_0, USING396_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:635:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER397=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid3545); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER397_tree = (CommonTree)adaptor.dupNode(INNER397);


                    adaptor.addChild(root_0, INNER397_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:636:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER398=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid3553); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER398_tree = (CommonTree)adaptor.dupNode(OUTER398);


                    adaptor.addChild(root_0, OUTER398_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:637:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL399=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid3561); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL399_tree = (CommonTree)adaptor.dupNode(PARALLEL399);


                    adaptor.addChild(root_0, PARALLEL399_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:638:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION400=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid3569); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION400_tree = (CommonTree)adaptor.dupNode(PARTITION400);


                    adaptor.addChild(root_0, PARTITION400_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:639:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP401=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid3577); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP401_tree = (CommonTree)adaptor.dupNode(GROUP401);


                    adaptor.addChild(root_0, GROUP401_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:640:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND402=(CommonTree)match(input,AND,FOLLOW_AND_in_eid3585); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND402_tree = (CommonTree)adaptor.dupNode(AND402);


                    adaptor.addChild(root_0, AND402_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:641:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR403=(CommonTree)match(input,OR,FOLLOW_OR_in_eid3593); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR403_tree = (CommonTree)adaptor.dupNode(OR403);


                    adaptor.addChild(root_0, OR403_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:642:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT404=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid3601); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT404_tree = (CommonTree)adaptor.dupNode(NOT404);


                    adaptor.addChild(root_0, NOT404_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:643:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE405=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid3609); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE405_tree = (CommonTree)adaptor.dupNode(GENERATE405);


                    adaptor.addChild(root_0, GENERATE405_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:644:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN406=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid3617); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN406_tree = (CommonTree)adaptor.dupNode(FLATTEN406);


                    adaptor.addChild(root_0, FLATTEN406_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:645:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL407=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid3625); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL407_tree = (CommonTree)adaptor.dupNode(EVAL407);


                    adaptor.addChild(root_0, EVAL407_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:646:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC408=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid3633); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC408_tree = (CommonTree)adaptor.dupNode(ASC408);


                    adaptor.addChild(root_0, ASC408_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:647:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC409=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid3641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC409_tree = (CommonTree)adaptor.dupNode(DESC409);


                    adaptor.addChild(root_0, DESC409_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:648:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN410=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid3649); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN410_tree = (CommonTree)adaptor.dupNode(BOOLEAN410);


                    adaptor.addChild(root_0, BOOLEAN410_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:649:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT411=(CommonTree)match(input,INT,FOLLOW_INT_in_eid3657); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT411_tree = (CommonTree)adaptor.dupNode(INT411);


                    adaptor.addChild(root_0, INT411_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:650:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG412=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid3665); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG412_tree = (CommonTree)adaptor.dupNode(LONG412);


                    adaptor.addChild(root_0, LONG412_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:651:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT413=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid3673); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT413_tree = (CommonTree)adaptor.dupNode(FLOAT413);


                    adaptor.addChild(root_0, FLOAT413_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:652:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE414=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid3681); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE414_tree = (CommonTree)adaptor.dupNode(DOUBLE414);


                    adaptor.addChild(root_0, DOUBLE414_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:653:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME415=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid3689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME415_tree = (CommonTree)adaptor.dupNode(DATETIME415);


                    adaptor.addChild(root_0, DATETIME415_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:654:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY416=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid3697); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY416_tree = (CommonTree)adaptor.dupNode(CHARARRAY416);


                    adaptor.addChild(root_0, CHARARRAY416_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:655:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY417=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid3705); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY417_tree = (CommonTree)adaptor.dupNode(BYTEARRAY417);


                    adaptor.addChild(root_0, BYTEARRAY417_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:656:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG418=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid3713); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG418_tree = (CommonTree)adaptor.dupNode(BAG418);


                    adaptor.addChild(root_0, BAG418_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:657:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE419=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid3721); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE419_tree = (CommonTree)adaptor.dupNode(TUPLE419);


                    adaptor.addChild(root_0, TUPLE419_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:658:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP420=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid3729); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP420_tree = (CommonTree)adaptor.dupNode(MAP420);


                    adaptor.addChild(root_0, MAP420_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:659:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS421=(CommonTree)match(input,IS,FOLLOW_IS_in_eid3737); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS421_tree = (CommonTree)adaptor.dupNode(IS421);


                    adaptor.addChild(root_0, IS421_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:660:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL422=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid3745); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL422_tree = (CommonTree)adaptor.dupNode(NULL422);


                    adaptor.addChild(root_0, NULL422_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:661:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE423=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid3753); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE423_tree = (CommonTree)adaptor.dupNode(TRUE423);


                    adaptor.addChild(root_0, TRUE423_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:662:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE424=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid3761); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE424_tree = (CommonTree)adaptor.dupNode(FALSE424);


                    adaptor.addChild(root_0, FALSE424_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:663:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM425=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid3769); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM425_tree = (CommonTree)adaptor.dupNode(STREAM425);


                    adaptor.addChild(root_0, STREAM425_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:664:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH426=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid3777); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH426_tree = (CommonTree)adaptor.dupNode(THROUGH426);


                    adaptor.addChild(root_0, THROUGH426_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:665:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE427=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid3785); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE427_tree = (CommonTree)adaptor.dupNode(STORE427);


                    adaptor.addChild(root_0, STORE427_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:666:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE428=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid3793); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE428_tree = (CommonTree)adaptor.dupNode(MAPREDUCE428);


                    adaptor.addChild(root_0, MAPREDUCE428_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:667:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP429=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid3801); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP429_tree = (CommonTree)adaptor.dupNode(SHIP429);


                    adaptor.addChild(root_0, SHIP429_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:668:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE430=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid3809); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE430_tree = (CommonTree)adaptor.dupNode(CACHE430);


                    adaptor.addChild(root_0, CACHE430_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:669:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT431=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid3817); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT431_tree = (CommonTree)adaptor.dupNode(INPUT431);


                    adaptor.addChild(root_0, INPUT431_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:670:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT432=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid3825); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT432_tree = (CommonTree)adaptor.dupNode(OUTPUT432);


                    adaptor.addChild(root_0, OUTPUT432_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:671:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR433=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid3833); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR433_tree = (CommonTree)adaptor.dupNode(STDERROR433);


                    adaptor.addChild(root_0, STDERROR433_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:672:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN434=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid3841); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN434_tree = (CommonTree)adaptor.dupNode(STDIN434);


                    adaptor.addChild(root_0, STDIN434_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:673:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT435=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid3849); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT435_tree = (CommonTree)adaptor.dupNode(STDOUT435);


                    adaptor.addChild(root_0, STDOUT435_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:674:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT436=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid3857); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT436_tree = (CommonTree)adaptor.dupNode(LIMIT436);


                    adaptor.addChild(root_0, LIMIT436_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:675:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE437=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid3865); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE437_tree = (CommonTree)adaptor.dupNode(SAMPLE437);


                    adaptor.addChild(root_0, SAMPLE437_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:676:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT438=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid3873); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT438_tree = (CommonTree)adaptor.dupNode(LEFT438);


                    adaptor.addChild(root_0, LEFT438_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:677:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT439=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid3881); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT439_tree = (CommonTree)adaptor.dupNode(RIGHT439);


                    adaptor.addChild(root_0, RIGHT439_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:678:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL440=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid3889); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL440_tree = (CommonTree)adaptor.dupNode(FULL440);


                    adaptor.addChild(root_0, FULL440_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:679:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER441=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid3897); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER441_tree = (CommonTree)adaptor.dupNode(IDENTIFIER441);


                    adaptor.addChild(root_0, IDENTIFIER441_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:680:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG442=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid3905); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG442_tree = (CommonTree)adaptor.dupNode(TOBAG442);


                    adaptor.addChild(root_0, TOBAG442_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:681:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP443=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid3913); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP443_tree = (CommonTree)adaptor.dupNode(TOMAP443);


                    adaptor.addChild(root_0, TOMAP443_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:682:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE444=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid3921); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE444_tree = (CommonTree)adaptor.dupNode(TOTUPLE444);


                    adaptor.addChild(root_0, TOTUPLE444_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "eid"


    public static class rel_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:686:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AliasMasker.rel_op_return rel_op() throws RecognitionException {
        AliasMasker.rel_op_return retval = new AliasMasker.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES451=null;
        AliasMasker.rel_op_eq_return rel_op_eq445 =null;

        AliasMasker.rel_op_ne_return rel_op_ne446 =null;

        AliasMasker.rel_op_gt_return rel_op_gt447 =null;

        AliasMasker.rel_op_gte_return rel_op_gte448 =null;

        AliasMasker.rel_op_lt_return rel_op_lt449 =null;

        AliasMasker.rel_op_lte_return rel_op_lte450 =null;


        CommonTree STR_OP_MATCHES451_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:687:5: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt109=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt109=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt109=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt109=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt109=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt109=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt109=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt109=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;

            }

            switch (alt109) {
                case 1 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:687:7: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op3935);
                    rel_op_eq445=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq445.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:688:7: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op3943);
                    rel_op_ne446=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne446.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:689:7: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op3951);
                    rel_op_gt447=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt447.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:690:7: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op3959);
                    rel_op_gte448=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte448.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:691:7: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op3967);
                    rel_op_lt449=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt449.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:692:7: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op3975);
                    rel_op_lte450=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte450.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:693:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES451=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op3983); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES451_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES451);


                    adaptor.addChild(root_0, STR_OP_MATCHES451_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op"


    public static class rel_op_eq_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_eq"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:696:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final AliasMasker.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AliasMasker.rel_op_eq_return retval = new AliasMasker.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set452=null;

        CommonTree set452_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:697:5: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set452=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set452_tree = (CommonTree)adaptor.dupNode(set452);


                adaptor.addChild(root_0, set452_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:701:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final AliasMasker.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AliasMasker.rel_op_ne_return retval = new AliasMasker.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set453=null;

        CommonTree set453_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:702:5: ( STR_OP_NE | NUM_OP_NE )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set453=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set453_tree = (CommonTree)adaptor.dupNode(set453);


                adaptor.addChild(root_0, set453_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_ne"


    public static class rel_op_gt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gt"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:706:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final AliasMasker.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AliasMasker.rel_op_gt_return retval = new AliasMasker.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set454=null;

        CommonTree set454_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:707:5: ( STR_OP_GT | NUM_OP_GT )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set454=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set454_tree = (CommonTree)adaptor.dupNode(set454);


                adaptor.addChild(root_0, set454_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gt"


    public static class rel_op_gte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gte"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:711:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final AliasMasker.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AliasMasker.rel_op_gte_return retval = new AliasMasker.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set455=null;

        CommonTree set455_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:712:5: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set455=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set455_tree = (CommonTree)adaptor.dupNode(set455);


                adaptor.addChild(root_0, set455_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gte"


    public static class rel_op_lt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lt"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:716:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final AliasMasker.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AliasMasker.rel_op_lt_return retval = new AliasMasker.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set456=null;

        CommonTree set456_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:717:5: ( STR_OP_LT | NUM_OP_LT )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set456=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set456_tree = (CommonTree)adaptor.dupNode(set456);


                adaptor.addChild(root_0, set456_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lt"


    public static class rel_op_lte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lte"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:721:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final AliasMasker.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AliasMasker.rel_op_lte_return retval = new AliasMasker.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set457=null;

        CommonTree set457_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:722:5: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set457=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set457_tree = (CommonTree)adaptor.dupNode(set457);


                adaptor.addChild(root_0, set457_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lte"


    public static class rel_str_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:726:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AliasMasker.rel_str_op_return rel_str_op() throws RecognitionException {
        AliasMasker.rel_str_op_return retval = new AliasMasker.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set458=null;

        CommonTree set458_tree=null;

        try {
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:727:5: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set458=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= STR_OP_EQ && input.LA(1) <= STR_OP_NE) ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set458_tree = (CommonTree)adaptor.dupNode(set458);


                adaptor.addChild(root_0, set458_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_str_op"

    // $ANTLR start synpred94_AliasMasker
    public final void synpred94_AliasMasker_fragment() throws RecognitionException {
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:326:7: ( ^( MINUS expr expr ) )
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:326:7: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred94_AliasMasker1613); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred94_AliasMasker1615);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred94_AliasMasker1617);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred94_AliasMasker

    // $ANTLR start synpred98_AliasMasker
    public final void synpred98_AliasMasker_fragment() throws RecognitionException {
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:330:7: ( ^( CAST_EXPR type expr ) )
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:330:7: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred98_AliasMasker1677); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred98_AliasMasker1679);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred98_AliasMasker1681);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred98_AliasMasker

    // $ANTLR start synpred99_AliasMasker
    public final void synpred99_AliasMasker_fragment() throws RecognitionException {
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:331:7: ( const_expr )
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:331:7: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred99_AliasMasker1691);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred99_AliasMasker

    // $ANTLR start synpred102_AliasMasker
    public final void synpred102_AliasMasker_fragment() throws RecognitionException {
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:334:7: ( ^( CAST_EXPR type_cast expr ) )
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:334:7: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred102_AliasMasker1723); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred102_AliasMasker1725);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred102_AliasMasker1727);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred102_AliasMasker

    // $ANTLR start synpred119_AliasMasker
    public final void synpred119_AliasMasker_fragment() throws RecognitionException {
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:387:22: ( INTEGER )
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:387:22: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred119_AliasMasker2028); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred119_AliasMasker

    // $ANTLR start synpred120_AliasMasker
    public final void synpred120_AliasMasker_fragment() throws RecognitionException {
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:387:32: ( LONGINTEGER )
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:387:32: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred120_AliasMasker2032); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred120_AliasMasker

    // $ANTLR start synpred121_AliasMasker
    public final void synpred121_AliasMasker_fragment() throws RecognitionException {
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:391:24: ( DOUBLENUMBER )
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:391:24: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred121_AliasMasker2062); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred121_AliasMasker

    // $ANTLR start synpred147_AliasMasker
    public final void synpred147_AliasMasker_fragment() throws RecognitionException {
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:448:7: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:448:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred147_AliasMasker2386);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
            input.consume();
            state.errorRecovery=false;
            state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:451:16: ( OUTER )?
        int alt117=2;
        int LA117_0 = input.LA(1);

        if ( (LA117_0==OUTER) ) {
            alt117=1;
        }
        switch (alt117) {
            case 1 :
                // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:451:16: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred147_AliasMasker2444); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred147_AliasMasker2447);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred147_AliasMasker

    // $ANTLR start synpred165_AliasMasker
    public final void synpred165_AliasMasker_fragment() throws RecognitionException {
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:519:34: ( INTEGER )
        // /home/iman/git/ReStoreV3/reStoreV3/src/org/apache/pig/parser/AliasMasker.g:519:34: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred165_AliasMasker2902); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred165_AliasMasker

    // Delegated rules

    public final boolean synpred99_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred147_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred147_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred98_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred165_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred165_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred94_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred120_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred120_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred121_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred121_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_QUERY_in_query81 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query83 = new BitSet(new long[]{0x0000000000000008L,0x0000004000000000L,0x0000000048000000L});
    public static final BitSet FOLLOW_general_statement_in_statement95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement162 = new BitSet(new long[]{0x3040090802264000L,0x0080184204004002L});
    public static final BitSet FOLLOW_op_clause_in_general_statement176 = new BitSet(new long[]{0x0000000000000008L,0x0000000000040000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement178 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause192 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause194 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause196 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause213 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause215 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause507 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_define_clause509 = new BitSet(new long[]{0x0000000200000000L,0x0000000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_cmd_in_define_clause514 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause518 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd538 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd551 = new BitSet(new long[]{0x0002000000001008L,0x0000010800020000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd555 = new BitSet(new long[]{0x0002000000001008L,0x0000010800020000L});
    public static final BitSet FOLLOW_input_clause_in_cmd559 = new BitSet(new long[]{0x0002000000001008L,0x0000010800020000L});
    public static final BitSet FOLLOW_output_clause_in_cmd563 = new BitSet(new long[]{0x0002000000001008L,0x0000010800020000L});
    public static final BitSet FOLLOW_error_clause_in_cmd567 = new BitSet(new long[]{0x0002000000001008L,0x0000010800020000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause588 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause590 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list607 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause625 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause627 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause647 = new BitSet(new long[]{0x0000000000000008L,0x0000060002000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd666 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd668 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd681 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd683 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd696 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd698 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause717 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause719 = new BitSet(new long[]{0x0000000000000008L,0x0000060002000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause738 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause742 = new BitSet(new long[]{0x0008000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause744 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause766 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause768 = new BitSet(new long[]{0x0000000000000048L,0x0000000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_func_clause_in_load_clause770 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_as_clause_in_load_clause773 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause816 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause818 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def835 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def837 = new BitSet(new long[]{0x4004002020082A08L,0x1000000000000000L,0x0000000400040000L});
    public static final BitSet FOLLOW_type_in_field_def839 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def854 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def856 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list871 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_simple_type_in_type882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type953 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type955 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type974 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type976 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type979 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type993 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type995 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1014 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1016 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1028 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1030 = new BitSet(new long[]{0x0000000000000008L,0x0000000002000000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1032 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1049 = new BitSet(new long[]{0x0000000008000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_set_in_func_name1053 = new BitSet(new long[]{0x70F7CF3C22AE7FF0L,0x01FFFF4B1C0F6023L,0x0000006381001000L});
    public static final BitSet FOLLOW_eid_in_func_name1063 = new BitSet(new long[]{0x0000000008000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1080 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1097 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1099 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1114 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1135 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1137 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1152 = new BitSet(new long[]{0x0000000000040002L,0x0000000100000000L});
    public static final BitSet FOLLOW_set_in_cube_rollup_list1168 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1178 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1193 = new BitSet(new long[]{0x8008088454040002L,0xC020008002500004L,0x000000100118141CL});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_group_clause1232 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1242 = new BitSet(new long[]{0x3040090802264008L,0x0080184206084002L,0x0000000000001000L});
    public static final BitSet FOLLOW_group_type_in_group_clause1245 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1248 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1274 = new BitSet(new long[]{0x0000000000000410L,0x0800000000000000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1278 = new BitSet(new long[]{0x0001000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_ALL_in_group_item1282 = new BitSet(new long[]{0x0001000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_ANY_in_group_item1286 = new BitSet(new long[]{0x0001000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_alias_in_rel1313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1319 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1350 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1354 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1358 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1362 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1383 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1385 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1403 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_store_clause1405 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_filename_in_store_clause1407 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1409 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1428 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1430 = new BitSet(new long[]{0x0000000000000020L,0x000FE00000002FE0L,0x0000000001000402L});
    public static final BitSet FOLLOW_cond_in_filter_clause1432 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1452 = new BitSet(new long[]{0x0000000000000020L,0x000FE00000002FE0L,0x0000000001000402L});
    public static final BitSet FOLLOW_cond_in_cond1454 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1466 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1468 = new BitSet(new long[]{0x0000000000000020L,0x000FE00000002FE0L,0x0000000001000402L});
    public static final BitSet FOLLOW_cond_in_cond1470 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1482 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1484 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1496 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1498 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000020L});
    public static final BitSet FOLLOW_NOT_in_cond1500 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond1513 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1515 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_cond1517 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_eval_in_cond1527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond1537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1539 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1556 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1558 = new BitSet(new long[]{0x8008088454040008L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1560 = new BitSet(new long[]{0x8008088454040008L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_real_arg1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg1581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr1597 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1599 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_expr1601 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1613 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1615 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_expr1617 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr1629 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1631 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_expr1633 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1647 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_expr1649 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr1661 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1663 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_expr1665 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1677 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr1679 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_expr1681 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr1691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr1709 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1711 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1723 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr1725 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_expr1727 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr1739 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1741 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast1769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1785 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast1787 = new BitSet(new long[]{0x4004002020082A08L,0x2000000000000000L,0x0000000800040000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1806 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast1808 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr1825 = new BitSet(new long[]{0x0000000000000002L,0x0000000000A00000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr1829 = new BitSet(new long[]{0x0000000000000002L,0x0000000000A00000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr1833 = new BitSet(new long[]{0x0000000000000002L,0x0000000000A00000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr1849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr1853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj1873 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj1875 = new BitSet(new long[]{0x0000080010040008L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index1887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range1948 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range1950 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range1953 = new BitSet(new long[]{0x0000080010040008L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_col_ref_in_col_range1955 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj1972 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_pound_proj1974 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr1999 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr2001 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_bin_expr2003 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_bin_expr2005 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause2022 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause2024 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause2028 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause2032 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause2036 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause2056 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause2058 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause2062 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause2066 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause2082 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause2084 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause2088 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement2105 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement2107 = new BitSet(new long[]{0x0000000000400008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement2111 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause2126 = new BitSet(new long[]{0x0000000000800082L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause2145 = new BitSet(new long[]{0x0000080010040002L,0x0000000000000000L,0x0000000000001008L});
    public static final BitSet FOLLOW_col_range_in_rank_col2158 = new BitSet(new long[]{0x0000000000800082L});
    public static final BitSet FOLLOW_col_ref_in_rank_col2162 = new BitSet(new long[]{0x0000000000800082L});
    public static final BitSet FOLLOW_ORDER_in_order_clause2190 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause2192 = new BitSet(new long[]{0x0000080010040000L,0x0000008000000000L,0x0000000000001008L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause2194 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_func_clause_in_order_clause2196 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause2212 = new BitSet(new long[]{0x0000000000800082L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause2231 = new BitSet(new long[]{0x0000080010040002L,0x0000000000000000L,0x0000000000001008L});
    public static final BitSet FOLLOW_col_range_in_order_col2246 = new BitSet(new long[]{0x0000000000800082L});
    public static final BitSet FOLLOW_col_ref_in_order_col2250 = new BitSet(new long[]{0x0000000000800082L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause2277 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause2279 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause2281 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause2299 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause2301 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause2318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause2320 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause2322 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list2338 = new BitSet(new long[]{0x3040090802264002L,0x0080184204004002L,0x0000000000001000L});
    public static final BitSet FOLLOW_JOIN_in_join_clause2354 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause2356 = new BitSet(new long[]{0x0000000000000008L,0x0000000002080000L});
    public static final BitSet FOLLOW_join_type_in_join_clause2358 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause2361 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type2373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2386 = new BitSet(new long[]{0x0080020000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_set_in_join_sub_clause2388 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000002000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause2444 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2455 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item2468 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item2470 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item2472 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause2489 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause2491 = new BitSet(new long[]{0x8008088454040008L,0xC020008002500004L,0x000000100118141CL});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr2508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr2512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr2516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause2533 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause2535 = new BitSet(new long[]{0x3040090802264000L,0x0080184204004002L,0x0000000000001000L});
    public static final BitSet FOLLOW_rel_list_in_union_clause2538 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause2560 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause2562 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause2564 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan2588 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2600 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan2602 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk2617 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000000600000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause2636 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause2638 = new BitSet(new long[]{0x8008089454040008L,0xC020008002500004L,0x000000100118141CL});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command2660 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2662 = new BitSet(new long[]{0x1000010802020000L,0x0000000000004000L,0x0000000000800000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command2664 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command2676 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2678 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_nested_command2680 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op2691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op2705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op2733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op2747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op2761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op2775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj2791 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2793 = new BitSet(new long[]{0x0000080010040000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2795 = new BitSet(new long[]{0x0000080010040008L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter2817 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter2819 = new BitSet(new long[]{0x0000000000000020L,0x000FE00000002FE0L,0x0000000001000402L});
    public static final BitSet FOLLOW_cond_in_nested_filter2821 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort2843 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort2845 = new BitSet(new long[]{0x0000080010040000L,0x0000008000000000L,0x0000000000001008L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort2847 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort2849 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct2872 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct2874 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit2896 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit2898 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit2902 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit2906 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross2921 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross2923 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach2936 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach2938 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach2940 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list2951 = new BitSet(new long[]{0x0000080010040002L,0x0000000000000000L,0x0000000000801000L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input2961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input2965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause2981 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause2983 = new BitSet(new long[]{0x0000000200000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_set_in_stream_clause2985 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause2995 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause3014 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause3016 = new BitSet(new long[]{0x0000000000000000L,0x0000080002000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause3018 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause3021 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause3023 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause3025 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause3044 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause3046 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause3048 = new BitSet(new long[]{0x0000000000000008L,0x0000000000008000L,0x0000000020000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause3051 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch3069 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch3071 = new BitSet(new long[]{0x0000000000000020L,0x000FE00000002FE0L,0x0000000001000402L});
    public static final BitSet FOLLOW_cond_in_split_branch3073 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise3091 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise3093 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref3105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref3123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_alias_col_ref3132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref3140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref3162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr3171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal3180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal3184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal3188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal3192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar3201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar3205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar3217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar3226 = new BitSet(new long[]{0x8008008040000000L});
    public static final BitSet FOLLOW_set_in_num_scalar3229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map3261 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map3263 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue3282 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue3284 = new BitSet(new long[]{0x8008008440000000L,0x4020000002000004L,0x0000001001080000L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue3286 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key3301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag3317 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag3319 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple3338 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple3340 = new BitSet(new long[]{0x8008008440000008L,0x4020000002000004L,0x0000001001080000L});
    public static final BitSet FOLLOW_rel_str_op_in_eid3353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid3361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid3369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid3377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid3385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid3393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid3401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid3409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid3425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANK_in_eid3441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid3449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid3457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid3465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid3473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid3481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid3489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid3497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid3505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid3513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid3521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid3537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid3545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid3553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid3569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid3585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid3593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid3601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid3609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid3617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid3625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid3633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid3641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid3649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid3665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid3673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid3681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid3689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid3697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid3705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid3713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid3729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid3737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid3753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid3761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid3769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid3785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid3801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid3809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid3817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid3825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid3833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid3849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid3857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid3865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid3873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid3881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid3889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid3897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid3905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid3913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid3921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op3935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op3943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op3951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op3959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op3967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op3975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op3983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred94_AliasMasker1613 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred94_AliasMasker1615 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_synpred94_AliasMasker1617 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred98_AliasMasker1677 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred98_AliasMasker1679 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_synpred98_AliasMasker1681 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred99_AliasMasker1691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred102_AliasMasker1723 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred102_AliasMasker1725 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_synpred102_AliasMasker1727 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_synpred119_AliasMasker2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred120_AliasMasker2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred121_AliasMasker2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred147_AliasMasker2386 = new BitSet(new long[]{0x0080020000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_set_in_synpred147_AliasMasker2388 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000002000L});
    public static final BitSet FOLLOW_OUTER_in_synpred147_AliasMasker2444 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_join_item_in_synpred147_AliasMasker2447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred165_AliasMasker2902 = new BitSet(new long[]{0x0000000000000002L});

}