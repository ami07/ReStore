// $ANTLR 3.4 /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g 2012-11-17 23:26:49

package org.apache.pig.parser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.impl.PigContext;
import org.apache.pig.impl.builtin.GFAny;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.streaming.StreamingCommand;
import org.apache.pig.impl.streaming.StreamingCommand.HandleSpec;
import org.apache.pig.impl.util.MultiMap;
import org.apache.pig.impl.util.NumValCarrier;
import org.apache.pig.impl.plan.PlanValidationException;
import org.apache.pig.newplan.Operator;
import org.apache.pig.newplan.logical.expression.AddExpression;
import org.apache.pig.newplan.logical.expression.AndExpression;
import org.apache.pig.newplan.logical.expression.BinCondExpression;
import org.apache.pig.newplan.logical.expression.CastExpression;
import org.apache.pig.newplan.logical.expression.ConstantExpression;
import org.apache.pig.newplan.logical.expression.DereferenceExpression;
import org.apache.pig.newplan.logical.expression.DivideExpression;
import org.apache.pig.newplan.logical.expression.EqualExpression;
import org.apache.pig.newplan.logical.expression.GreaterThanEqualExpression;
import org.apache.pig.newplan.logical.expression.GreaterThanExpression;
import org.apache.pig.newplan.logical.expression.IsNullExpression;
import org.apache.pig.newplan.logical.expression.LessThanEqualExpression;
import org.apache.pig.newplan.logical.expression.LessThanExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpressionPlan;
import org.apache.pig.newplan.logical.expression.MapLookupExpression;
import org.apache.pig.newplan.logical.expression.ModExpression;
import org.apache.pig.newplan.logical.expression.MultiplyExpression;
import org.apache.pig.newplan.logical.expression.NegativeExpression;
import org.apache.pig.newplan.logical.expression.NotEqualExpression;
import org.apache.pig.newplan.logical.expression.NotExpression;
import org.apache.pig.newplan.logical.expression.OrExpression;
import org.apache.pig.newplan.logical.expression.ProjectExpression;
import org.apache.pig.newplan.logical.expression.RegexExpression;
import org.apache.pig.newplan.logical.expression.ScalarExpression;
import org.apache.pig.newplan.logical.expression.SubtractExpression;
import org.apache.pig.newplan.logical.expression.UserFuncExpression;
import org.apache.pig.newplan.logical.relational.LOCogroup;
import org.apache.pig.newplan.logical.relational.LOCube;
import org.apache.pig.newplan.logical.relational.LOFilter;
import org.apache.pig.newplan.logical.relational.LOForEach;
import org.apache.pig.newplan.logical.relational.LOGenerate;
import org.apache.pig.newplan.logical.relational.LOLimit;
import org.apache.pig.newplan.logical.relational.LOJoin;
import org.apache.pig.newplan.logical.relational.LOSort;
import org.apache.pig.newplan.logical.relational.LORank;
import org.apache.pig.newplan.logical.relational.LOSplitOutput;
import org.apache.pig.newplan.logical.relational.LogicalPlan;
import org.apache.pig.newplan.logical.relational.LogicalRelationalOperator;
import org.apache.pig.newplan.logical.relational.LogicalSchema;
import org.apache.pig.newplan.logical.relational.LogicalSchema.LogicalFieldSchema;
import org.apache.pig.newplan.logical.relational.LOCogroup.GROUPTYPE;
import org.apache.pig.newplan.logical.relational.LOJoin.JOINTYPE;
import org.apache.pig.FuncSpec;
import org.apache.pig.builtin.PigStreaming;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.DataType;
import org.apache.pig.data.Tuple;
import java.util.Arrays;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (for schema alias validation).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL 
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class LogicalPlanGenerator extends TreeParser {
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

    protected static class GScope_scope {
        LogicalRelationalOperator currentOp;
    }
    protected Stack GScope_stack = new Stack();



    public LogicalPlanGenerator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public LogicalPlanGenerator(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return LogicalPlanGenerator.tokenNames; }
    public String getGrammarFileName() { return "/home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g"; }


    private static Log log = LogFactory.getLog( LogicalPlanGenerator.class );

    private LogicalPlanBuilder builder = null;

    private boolean inForeachPlan = false;

    private boolean inNestedCommand = false;

    public LogicalPlan getLogicalPlan() {
        return builder.getPlan();
    }

    public Map<String, Operator> getOperators() {
        return builder.getOperators();
    }

    @Override
    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) 
    throws RecognitionException {
        throw new MismatchedTokenException( ttype, input );
    }

    @Override
    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
    throws RecognitionException {
        throw e;
    }

    public LogicalPlanGenerator(TreeNodeStream input, LogicalPlanBuilder builder) {
        this(input, new RecognizerSharedState());
        this.builder = builder;
    }

    public LogicalPlanGenerator(TreeNodeStream input, PigContext pigContext, String scope,
        Map<String, String> fileNameMap) {
        this( input );
        builder = new LogicalPlanBuilder( pigContext, scope, fileNameMap, input );
    }



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:152:1: query : ^( QUERY ( statement )* ) ;
    public final LogicalPlanGenerator.query_return query() throws RecognitionException {
        LogicalPlanGenerator.query_return retval = new LogicalPlanGenerator.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        LogicalPlanGenerator.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:152:7: ( ^( QUERY ( statement )* ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:152:9: ^( QUERY ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_query88); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUERY1_tree = (CommonTree)adaptor.dupNode(QUERY1);


            root_1 = (CommonTree)adaptor.becomeRoot(QUERY1_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:152:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:152:18: statement
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_query90);
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


    protected static class statement_scope {
        String alias;
        Integer parallel;
        String inputAlias;
        int inputIndex;
    }
    protected Stack statement_stack = new Stack();


    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:155:1: statement : ( general_statement | split_statement | realias_statement );
    public final LogicalPlanGenerator.statement_return statement() throws RecognitionException {
        statement_stack.push(new statement_scope());
        LogicalPlanGenerator.statement_return retval = new LogicalPlanGenerator.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.general_statement_return general_statement3 =null;

        LogicalPlanGenerator.split_statement_return split_statement4 =null;

        LogicalPlanGenerator.realias_statement_return realias_statement5 =null;




            ((statement_scope)statement_stack.peek()).inputIndex = 0;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:166:2: ( general_statement | split_statement | realias_statement )
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
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:166:4: general_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_general_statement_in_statement112);
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
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:167:4: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement117);
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
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:168:4: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement122);
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
            statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class split_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_statement"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:171:1: split_statement : split_clause ;
    public final LogicalPlanGenerator.split_statement_return split_statement() throws RecognitionException {
        LogicalPlanGenerator.split_statement_return retval = new LogicalPlanGenerator.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.split_clause_return split_clause6 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:171:17: ( split_clause )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:171:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement131);
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:174:1: realias_statement : realias_clause ;
    public final LogicalPlanGenerator.realias_statement_return realias_statement() throws RecognitionException {
        LogicalPlanGenerator.realias_statement_return retval = new LogicalPlanGenerator.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.realias_clause_return realias_clause7 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:174:19: ( realias_clause )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:174:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement140);
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:177:1: general_statement : ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) ;
    public final LogicalPlanGenerator.general_statement_return general_statement() throws RecognitionException {
        LogicalPlanGenerator.general_statement_return retval = new LogicalPlanGenerator.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT8=null;
        LogicalPlanGenerator.op_clause_return oa =null;

        LogicalPlanGenerator.alias_return alias9 =null;

        LogicalPlanGenerator.parallel_clause_return parallel_clause10 =null;


        CommonTree STATEMENT8_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:178:3: ( ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:178:3: ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT8=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement152); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT8_tree = (CommonTree)adaptor.dupNode(STATEMENT8);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT8_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:178:16: ( alias )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:178:18: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement156);
                    alias9=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias9.getTree());


                    if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = (alias9!=null?alias9.name:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement167);
            oa=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, oa.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:178:79: ( parallel_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PARALLEL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:178:79: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement169);
                    parallel_clause10=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause10.getTree());


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
                  Operator op = builder.lookupOperator( (oa!=null?oa.alias:null) );
                  builder.setParallel( (LogicalRelationalOperator)op, ((statement_scope)statement_stack.peek()).parallel );
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:185:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final LogicalPlanGenerator.realias_clause_return realias_clause() throws RecognitionException {
        LogicalPlanGenerator.realias_clause_return retval = new LogicalPlanGenerator.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS11=null;
        CommonTree IDENTIFIER13=null;
        LogicalPlanGenerator.alias_return alias12 =null;


        CommonTree REALIAS11_tree=null;
        CommonTree IDENTIFIER13_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:186:3: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:186:3: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS11=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause186); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS11_tree = (CommonTree)adaptor.dupNode(REALIAS11);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS11_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause188);
            alias12=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias12.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER13=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause190); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER13_tree = (CommonTree)adaptor.dupNode(IDENTIFIER13);


            adaptor.addChild(root_1, IDENTIFIER13_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            	    Operator op = builder.lookupOperator( (IDENTIFIER13!=null?IDENTIFIER13.getText():null) );
            	    if (op==null) {
            	        throw new UndefinedAliasException(input, 
            	            new SourceLocation( (PigParserNode)IDENTIFIER13 ), (IDENTIFIER13!=null?IDENTIFIER13.getText():null));
            	    }
            	    builder.putOperator( (alias12!=null?alias12.name:null), (LogicalRelationalOperator)op );
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:197:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final LogicalPlanGenerator.parallel_clause_return parallel_clause() throws RecognitionException {
        LogicalPlanGenerator.parallel_clause_return retval = new LogicalPlanGenerator.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL14=null;
        CommonTree INTEGER15=null;

        CommonTree PARALLEL14_tree=null;
        CommonTree INTEGER15_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:2: ( ^( PARALLEL INTEGER ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:4: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL14=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause209); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL14_tree = (CommonTree)adaptor.dupNode(PARALLEL14);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL14_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER15=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause211); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER15_tree = (CommonTree)adaptor.dupNode(INTEGER15);


            adaptor.addChild(root_1, INTEGER15_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   ((statement_scope)statement_stack.peek()).parallel = Integer.parseInt( (INTEGER15!=null?INTEGER15.getText():null) );
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
        public String name;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:204:1: alias returns [String name] : IDENTIFIER ;
    public final LogicalPlanGenerator.alias_return alias() throws RecognitionException {
        LogicalPlanGenerator.alias_return retval = new LogicalPlanGenerator.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER16=null;

        CommonTree IDENTIFIER16_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:204:27: ( IDENTIFIER )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:204:29: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER16=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias229); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER16_tree = (CommonTree)adaptor.dupNode(IDENTIFIER16);


            adaptor.addChild(root_0, IDENTIFIER16_tree);
            }


            if ( state.backtracking==0 ) { retval.name = (IDENTIFIER16!=null?IDENTIFIER16.getText():null); }

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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:207:1: op_clause returns [String alias] : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause | cube_clause );
    public final LogicalPlanGenerator.op_clause_return op_clause() throws RecognitionException {
        LogicalPlanGenerator.op_clause_return retval = new LogicalPlanGenerator.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.define_clause_return define_clause17 =null;

        LogicalPlanGenerator.load_clause_return load_clause18 =null;

        LogicalPlanGenerator.group_clause_return group_clause19 =null;

        LogicalPlanGenerator.store_clause_return store_clause20 =null;

        LogicalPlanGenerator.filter_clause_return filter_clause21 =null;

        LogicalPlanGenerator.distinct_clause_return distinct_clause22 =null;

        LogicalPlanGenerator.limit_clause_return limit_clause23 =null;

        LogicalPlanGenerator.sample_clause_return sample_clause24 =null;

        LogicalPlanGenerator.order_clause_return order_clause25 =null;

        LogicalPlanGenerator.rank_clause_return rank_clause26 =null;

        LogicalPlanGenerator.cross_clause_return cross_clause27 =null;

        LogicalPlanGenerator.join_clause_return join_clause28 =null;

        LogicalPlanGenerator.union_clause_return union_clause29 =null;

        LogicalPlanGenerator.stream_clause_return stream_clause30 =null;

        LogicalPlanGenerator.mr_clause_return mr_clause31 =null;

        LogicalPlanGenerator.foreach_clause_return foreach_clause32 =null;

        LogicalPlanGenerator.cube_clause_return cube_clause33 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:207:33: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause | cube_clause )
            int alt5=17;
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
            case FOREACH:
                {
                alt5=16;
                }
                break;
            case CUBE:
                {
                alt5=17;
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
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:208:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause256);
                    define_clause17=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause17.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:209:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause271);
                    load_clause18=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause18.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (load_clause18!=null?load_clause18.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:210:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause287);
                    group_clause19=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause19.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (group_clause19!=null?group_clause19.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:211:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause303);
                    store_clause20=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause20.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (store_clause20!=null?store_clause20.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:212:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause319);
                    filter_clause21=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause21.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (filter_clause21!=null?filter_clause21.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:213:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause335);
                    distinct_clause22=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause22.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (distinct_clause22!=null?distinct_clause22.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:214:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause351);
                    limit_clause23=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause23.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (limit_clause23!=null?limit_clause23.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:215:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause367);
                    sample_clause24=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause24.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (sample_clause24!=null?sample_clause24.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:216:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause383);
                    order_clause25=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause25.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (order_clause25!=null?order_clause25.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:217:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause399);
                    rank_clause26=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause26.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (rank_clause26!=null?rank_clause26.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:218:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause415);
                    cross_clause27=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause27.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (cross_clause27!=null?cross_clause27.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:219:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause431);
                    join_clause28=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause28.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (join_clause28!=null?join_clause28.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:220:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause447);
                    union_clause29=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause29.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (union_clause29!=null?union_clause29.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:221:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause463);
                    stream_clause30=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause30.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (stream_clause30!=null?stream_clause30.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:222:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause479);
                    mr_clause31=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause31.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (mr_clause31!=null?mr_clause31.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:223:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause495);
                    foreach_clause32=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause32.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (foreach_clause32!=null?foreach_clause32.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:224:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause511);
                    cube_clause33=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause33.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (cube_clause33!=null?cube_clause33.alias:null); }

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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:227:1: define_clause : ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) );
    public final LogicalPlanGenerator.define_clause_return define_clause() throws RecognitionException {
        LogicalPlanGenerator.define_clause_return retval = new LogicalPlanGenerator.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE34=null;
        CommonTree DEFINE37=null;
        LogicalPlanGenerator.alias_return alias35 =null;

        LogicalPlanGenerator.cmd_return cmd36 =null;

        LogicalPlanGenerator.alias_return alias38 =null;

        LogicalPlanGenerator.func_clause_return func_clause39 =null;


        CommonTree DEFINE34_tree=null;
        CommonTree DEFINE37_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:228:2: ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==DEFINE) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==DOWN) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==IDENTIFIER) ) {
                        int LA6_3 = input.LA(4);

                        if ( (LA6_3==EXECCOMMAND) ) {
                            alt6=1;
                        }
                        else if ( (LA6_3==FUNC||LA6_3==FUNC_REF) ) {
                            alt6=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:228:4: ^( DEFINE alias cmd[$alias.name] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DEFINE34=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause526); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE34_tree = (CommonTree)adaptor.dupNode(DEFINE34);


                    root_1 = (CommonTree)adaptor.becomeRoot(DEFINE34_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_define_clause528);
                    alias35=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias35.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause530);
                    cmd36=cmd((alias35!=null?alias35.name:null));

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd36.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           builder.defineCommand( (alias35!=null?alias35.name:null), (cmd36!=null?cmd36.command:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:232:4: ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DEFINE37=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause546); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE37_tree = (CommonTree)adaptor.dupNode(DEFINE37);


                    root_1 = (CommonTree)adaptor.becomeRoot(DEFINE37_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_define_clause548);
                    alias38=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias38.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause550);
                    func_clause39=func_clause(FunctionType.UNKNOWNFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause39.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           builder.defineFunction( (alias38!=null?alias38.name:null), (func_clause39!=null?func_clause39.funcSpec:null) );
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
    // $ANTLR end "define_clause"


    public static class cmd_return extends TreeRuleReturnScope {
        public StreamingCommand command;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cmd"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:238:1: cmd[String alias] returns [StreamingCommand command] : ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) ;
    public final LogicalPlanGenerator.cmd_return cmd(String alias) throws RecognitionException {
        LogicalPlanGenerator.cmd_return retval = new LogicalPlanGenerator.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND40=null;
        LogicalPlanGenerator.ship_clause_return ship_clause41 =null;

        LogicalPlanGenerator.cache_clause_return cache_clause42 =null;

        LogicalPlanGenerator.input_clause_return input_clause43 =null;

        LogicalPlanGenerator.output_clause_return output_clause44 =null;

        LogicalPlanGenerator.error_clause_return error_clause45 =null;


        CommonTree EXECCOMMAND40_tree=null;


            List<String> shipPaths = new ArrayList<String>();
            List<String> cachePaths = new ArrayList<String>();
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:244:2: ( ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:244:4: ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND40=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd579); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND40_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND40);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND40_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:244:19: ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )*
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
                	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:244:21: ship_clause[shipPaths]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd583);
                	    ship_clause41=ship_clause(shipPaths);

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause41.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:244:46: cache_clause[cachePaths]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd588);
                	    cache_clause42=cache_clause(cachePaths);

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause42.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:244:73: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd593);
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
                	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:244:88: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd597);
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
                	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:244:104: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd601);
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
                   retval.command = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND40!=null?EXECCOMMAND40.getText():null) ), shipPaths,
                       cachePaths, (input_clause43!=null?input_clause43.inputHandleSpecs:null), (output_clause44!=null?output_clause44.outputHandleSpecs:null),
                       (error_clause45!=null?error_clause45.dir:null), (error_clause45!=null?error_clause45.limit:null) );
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:252:1: ship_clause[List<String> paths] : ^( SHIP ( path_list[$paths] )? ) ;
    public final LogicalPlanGenerator.ship_clause_return ship_clause(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.ship_clause_return retval = new LogicalPlanGenerator.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP46=null;
        LogicalPlanGenerator.path_list_return path_list47 =null;


        CommonTree SHIP46_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:253:2: ( ^( SHIP ( path_list[$paths] )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:253:4: ^( SHIP ( path_list[$paths] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP46=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause624); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP46_tree = (CommonTree)adaptor.dupNode(SHIP46);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP46_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:253:12: ( path_list[$paths] )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTEDSTRING) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:253:12: path_list[$paths]
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause626);
                        path_list47=path_list(paths);

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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:256:1: path_list[List<String> paths] : ( QUOTEDSTRING )+ ;
    public final LogicalPlanGenerator.path_list_return path_list(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.path_list_return retval = new LogicalPlanGenerator.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING48=null;

        CommonTree QUOTEDSTRING48_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:257:2: ( ( QUOTEDSTRING )+ )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:257:4: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:257:4: ( QUOTEDSTRING )+
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
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:257:6: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING48=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list643); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING48_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING48);


            	    adaptor.addChild(root_0, QUOTEDSTRING48_tree);
            	    }


            	    if ( state.backtracking==0 ) { paths.add( builder.unquote( (QUOTEDSTRING48!=null?QUOTEDSTRING48.getText():null) ) ); }

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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:260:1: cache_clause[List<String> paths] : ^( CACHE path_list[$paths] ) ;
    public final LogicalPlanGenerator.cache_clause_return cache_clause(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.cache_clause_return retval = new LogicalPlanGenerator.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE49=null;
        LogicalPlanGenerator.path_list_return path_list50 =null;


        CommonTree CACHE49_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:261:2: ( ^( CACHE path_list[$paths] ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:261:4: ^( CACHE path_list[$paths] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE49=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause661); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE49_tree = (CommonTree)adaptor.dupNode(CACHE49);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE49_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause663);
            path_list50=path_list(paths);

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
        public List<HandleSpec> inputHandleSpecs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:264:1: input_clause returns [List<HandleSpec> inputHandleSpecs] : ^( INPUT ( stream_cmd[true] )+ ) ;
    public final LogicalPlanGenerator.input_clause_return input_clause() throws RecognitionException {
        LogicalPlanGenerator.input_clause_return retval = new LogicalPlanGenerator.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT51=null;
        LogicalPlanGenerator.stream_cmd_return stream_cmd52 =null;


        CommonTree INPUT51_tree=null;


            retval.inputHandleSpecs = new ArrayList<HandleSpec>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:268:2: ( ^( INPUT ( stream_cmd[true] )+ ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:268:4: ^( INPUT ( stream_cmd[true] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT51=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause686); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT51_tree = (CommonTree)adaptor.dupNode(INPUT51);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT51_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:268:13: ( stream_cmd[true] )+
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
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:268:15: stream_cmd[true]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause690);
            	    stream_cmd52=stream_cmd(true);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd52.getTree());


            	    if ( state.backtracking==0 ) { retval.inputHandleSpecs.add( (stream_cmd52!=null?stream_cmd52.handleSpec:null) ); }

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
        public HandleSpec handleSpec;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:271:1: stream_cmd[boolean in] returns [HandleSpec handleSpec] : ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) );
    public final LogicalPlanGenerator.stream_cmd_return stream_cmd(boolean in) throws RecognitionException {
        LogicalPlanGenerator.stream_cmd_return retval = new LogicalPlanGenerator.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN53=null;
        CommonTree STDOUT55=null;
        CommonTree QUOTEDSTRING57=null;
        LogicalPlanGenerator.func_clause_return func_clause54 =null;

        LogicalPlanGenerator.func_clause_return func_clause56 =null;

        LogicalPlanGenerator.func_clause_return func_clause58 =null;


        CommonTree STDIN53_tree=null;
        CommonTree STDOUT55_tree=null;
        CommonTree QUOTEDSTRING57_tree=null;


            String handleName = null;
            FuncSpec fs = null;
            String deserializer = PigStreaming.class.getName() + "()";
            byte ft = in ? FunctionType.PIGTOSTREAMFUNC : FunctionType.STREAMTOPIGFUNC;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:283:2: ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) )
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
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:283:4: ^( STDIN ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN53=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd724); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN53_tree = (CommonTree)adaptor.dupNode(STDIN53);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN53_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = "stdin"; }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:284:7: ( func_clause[ft] )?
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==FUNC||LA11_0==FUNC_REF) ) {
                            alt11=1;
                        }
                        switch (alt11) {
                            case 1 :
                                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:284:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd736);
                                func_clause54=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause54.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause54!=null?func_clause54.funcSpec:null); }

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
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:285:4: ^( STDOUT ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT55=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd751); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT55_tree = (CommonTree)adaptor.dupNode(STDOUT55);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT55_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = "stdout"; }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:286:7: ( func_clause[ft] )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:286:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd763);
                                func_clause56=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause56.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause56!=null?func_clause56.funcSpec:null); }

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
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:287:4: ^( QUOTEDSTRING ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING57=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd778); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING57_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING57);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING57_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = builder.unquote( (QUOTEDSTRING57!=null?QUOTEDSTRING57.getText():null) ); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:288:7: ( func_clause[ft] )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:288:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd790);
                                func_clause58=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause58.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause58!=null?func_clause58.funcSpec:null); }

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

            if ( state.backtracking==0 ) {
                if( fs != null )
                    deserializer =  fs.toString();
                retval.handleSpec = new HandleSpec( handleName, deserializer );
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
        public List<HandleSpec> outputHandleSpecs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "output_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:291:1: output_clause returns [List<HandleSpec> outputHandleSpecs] : ^( OUTPUT ( stream_cmd[false] )+ ) ;
    public final LogicalPlanGenerator.output_clause_return output_clause() throws RecognitionException {
        LogicalPlanGenerator.output_clause_return retval = new LogicalPlanGenerator.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT59=null;
        LogicalPlanGenerator.stream_cmd_return stream_cmd60 =null;


        CommonTree OUTPUT59_tree=null;


            retval.outputHandleSpecs = new ArrayList<HandleSpec>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:295:2: ( ^( OUTPUT ( stream_cmd[false] )+ ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:295:4: ^( OUTPUT ( stream_cmd[false] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT59=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause818); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT59_tree = (CommonTree)adaptor.dupNode(OUTPUT59);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT59_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:295:14: ( stream_cmd[false] )+
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
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:295:16: stream_cmd[false]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause822);
            	    stream_cmd60=stream_cmd(false);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd60.getTree());


            	    if ( state.backtracking==0 ) { retval.outputHandleSpecs.add( (stream_cmd60!=null?stream_cmd60.handleSpec:null) ); }

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
        public String dir;
        public Integer limit;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:298:1: error_clause returns [String dir, Integer limit] : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final LogicalPlanGenerator.error_clause_return error_clause() throws RecognitionException {
        LogicalPlanGenerator.error_clause_return retval = new LogicalPlanGenerator.error_clause_return();
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


            retval.limit = StreamingCommand.MAX_TASKS;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:302:2: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:302:4: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR61=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause850); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR61_tree = (CommonTree)adaptor.dupNode(STDERROR61);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR61_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:303:7: ( QUOTEDSTRING ( INTEGER )? )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUOTEDSTRING) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:303:9: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING62=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause861); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING62_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING62);


                        adaptor.addChild(root_1, QUOTEDSTRING62_tree);
                        }


                        if ( state.backtracking==0 ) {
                                    retval.dir = builder.unquote( (QUOTEDSTRING62!=null?QUOTEDSTRING62.getText():null) );
                                }

                        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:307:9: ( INTEGER )?
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==INTEGER) ) {
                            alt16=1;
                        }
                        switch (alt16) {
                            case 1 :
                                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:307:11: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER63=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause884); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER63_tree = (CommonTree)adaptor.dupNode(INTEGER63);


                                adaptor.addChild(root_1, INTEGER63_tree);
                                }


                                if ( state.backtracking==0 ) { 
                                              retval.limit = Integer.parseInt( (INTEGER63!=null?INTEGER63.getText():null) );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:316:1: load_clause returns [String alias] : ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) ;
    public final LogicalPlanGenerator.load_clause_return load_clause() throws RecognitionException {
        LogicalPlanGenerator.load_clause_return retval = new LogicalPlanGenerator.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD64=null;
        LogicalPlanGenerator.filename_return filename65 =null;

        LogicalPlanGenerator.func_clause_return func_clause66 =null;

        LogicalPlanGenerator.as_clause_return as_clause67 =null;


        CommonTree LOAD64_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:317:2: ( ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:317:4: ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD64=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause938); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD64_tree = (CommonTree)adaptor.dupNode(LOAD64);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD64_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause940);
            filename65=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename65.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:317:21: ( func_clause[FunctionType.LOADFUNC] )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FUNC||LA18_0==FUNC_REF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:317:21: func_clause[FunctionType.LOADFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause942);
                    func_clause66=func_clause(FunctionType.LOADFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause66.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:317:57: ( as_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:317:57: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause946);
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
                  SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                  retval.alias = builder.buildLoadOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      (filename65!=null?filename65.filename:null), (func_clause66!=null?func_clause66.funcSpec:null), (as_clause67!=null?as_clause67.logicalSchema:null)  );
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
        public String filename;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filename"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:325:1: filename returns [String filename] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.filename_return filename() throws RecognitionException {
        LogicalPlanGenerator.filename_return retval = new LogicalPlanGenerator.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING68=null;

        CommonTree QUOTEDSTRING68_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:326:2: ( QUOTEDSTRING )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:326:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING68=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename966); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING68_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING68);


            adaptor.addChild(root_0, QUOTEDSTRING68_tree);
            }


            if ( state.backtracking==0 ) { retval.filename = builder.unquote( (QUOTEDSTRING68!=null?QUOTEDSTRING68.getText():null) ); }

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
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:329:1: as_clause returns [LogicalSchema logicalSchema] : ^( AS field_def_list ) ;
    public final LogicalPlanGenerator.as_clause_return as_clause() throws RecognitionException {
        LogicalPlanGenerator.as_clause_return retval = new LogicalPlanGenerator.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS69=null;
        LogicalPlanGenerator.field_def_list_return field_def_list70 =null;


        CommonTree AS69_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:330:2: ( ^( AS field_def_list ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:330:4: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS69=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause983); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS69_tree = (CommonTree)adaptor.dupNode(AS69);


            root_1 = (CommonTree)adaptor.becomeRoot(AS69_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause985);
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
                    LogicalPlanBuilder.setBytearrayForNULLType((field_def_list70!=null?field_def_list70.schema:null));
                    retval.logicalSchema = (field_def_list70!=null?field_def_list70.schema:null); 
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
    // $ANTLR end "as_clause"


    public static class field_def_return extends TreeRuleReturnScope {
        public LogicalFieldSchema fieldSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:337:1: field_def[NumValCarrier nvc] returns [LogicalFieldSchema fieldSchema] : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) ) );
    public final LogicalPlanGenerator.field_def_return field_def(NumValCarrier nvc) throws RecognitionException {
        LogicalPlanGenerator.field_def_return retval = new LogicalPlanGenerator.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF71=null;
        CommonTree IDENTIFIER72=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER74=null;
        LogicalPlanGenerator.type_return type73 =null;

        LogicalPlanGenerator.type_return type75 =null;


        CommonTree FIELD_DEF71_tree=null;
        CommonTree IDENTIFIER72_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER74_tree=null;


            byte datatype = DataType.NULL;          
            if (nvc==null) {
                nvc =new NumValCarrier();
            }

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:344:2: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) ) )
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
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:344:4: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF71=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def1014); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF71_tree = (CommonTree)adaptor.dupNode(FIELD_DEF71);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF71_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER72=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def1016); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER72_tree = (CommonTree)adaptor.dupNode(IDENTIFIER72);


                    adaptor.addChild(root_1, IDENTIFIER72_tree);
                    }


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:344:28: ( type )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==BOOLEAN||LA20_0==BYTEARRAY||LA20_0==CHARARRAY||LA20_0==DATETIME||LA20_0==DOUBLE||LA20_0==FLOAT||LA20_0==INT||LA20_0==LONG||LA20_0==BAG_TYPE||LA20_0==MAP_TYPE||LA20_0==TUPLE_TYPE) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:344:30: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def1020);
                            type73=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type73.getTree());


                            if ( state.backtracking==0 ) { datatype = (type73!=null?type73.datatype:null);}

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
                               retval.fieldSchema = new LogicalFieldSchema( (IDENTIFIER72!=null?IDENTIFIER72.getText():null), (type73!=null?type73.logicalSchema:null), datatype );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:348:4: ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER74=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def1039); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER74_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER74);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER74_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:348:36: ( type )
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:348:38: type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def1043);
                    type75=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type75.getTree());


                    if ( state.backtracking==0 ) { datatype = (type75!=null?type75.datatype:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                               retval.fieldSchema = new LogicalFieldSchema ( nvc.makeNameFromDataType(datatype) , (type75!=null?type75.logicalSchema:null), datatype );
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
        public LogicalSchema schema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:354:1: field_def_list returns [LogicalSchema schema] : ( field_def[nvc] )+ ;
    public final LogicalPlanGenerator.field_def_list_return field_def_list() throws RecognitionException {
        LogicalPlanGenerator.field_def_list_return retval = new LogicalPlanGenerator.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.field_def_return field_def76 =null;




            retval.schema = new LogicalSchema();
            NumValCarrier nvc = new NumValCarrier();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:359:2: ( ( field_def[nvc] )+ )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:359:4: ( field_def[nvc] )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:359:4: ( field_def[nvc] )+
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
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:359:6: field_def[nvc]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list1074);
            	    field_def76=field_def(nvc);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def76.getTree());


            	    if ( state.backtracking==0 ) { retval.schema.addField( (field_def76!=null?field_def76.fieldSchema:null) ); }

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
        public Byte datatype;
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:363:1: type returns [Byte datatype, LogicalSchema logicalSchema] : ( simple_type | tuple_type | bag_type | map_type );
    public final LogicalPlanGenerator.type_return type() throws RecognitionException {
        LogicalPlanGenerator.type_return retval = new LogicalPlanGenerator.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.simple_type_return simple_type77 =null;

        LogicalPlanGenerator.tuple_type_return tuple_type78 =null;

        LogicalPlanGenerator.bag_type_return bag_type79 =null;

        LogicalPlanGenerator.map_type_return map_type80 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:364:2: ( simple_type | tuple_type | bag_type | map_type )
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
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:364:4: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type1094);
                    simple_type77=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type77.getTree());


                    if ( state.backtracking==0 ) {
                            retval.datatype = (simple_type77!=null?simple_type77.datatype:0);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:368:4: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type1104);
                    tuple_type78=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type78.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.TUPLE;
                           retval.logicalSchema = (tuple_type78!=null?tuple_type78.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:373:4: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type1114);
                    bag_type79=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type79.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.BAG;
                           retval.logicalSchema = (bag_type79!=null?bag_type79.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:378:4: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type1124);
                    map_type80=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type80.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.MAP;
                           retval.logicalSchema = (map_type80!=null?map_type80.logicalSchema:null);
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
    // $ANTLR end "type"


    public static class simple_type_return extends TreeRuleReturnScope {
        public byte datatype;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:385:1: simple_type returns [byte datatype] : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY );
    public final LogicalPlanGenerator.simple_type_return simple_type() throws RecognitionException {
        LogicalPlanGenerator.simple_type_return retval = new LogicalPlanGenerator.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BOOLEAN81=null;
        CommonTree INT82=null;
        CommonTree LONG83=null;
        CommonTree FLOAT84=null;
        CommonTree DOUBLE85=null;
        CommonTree DATETIME86=null;
        CommonTree CHARARRAY87=null;
        CommonTree BYTEARRAY88=null;

        CommonTree BOOLEAN81_tree=null;
        CommonTree INT82_tree=null;
        CommonTree LONG83_tree=null;
        CommonTree FLOAT84_tree=null;
        CommonTree DOUBLE85_tree=null;
        CommonTree DATETIME86_tree=null;
        CommonTree CHARARRAY87_tree=null;
        CommonTree BYTEARRAY88_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:386:2: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY )
            int alt24=8;
            switch ( input.LA(1) ) {
            case BOOLEAN:
                {
                alt24=1;
                }
                break;
            case INT:
                {
                alt24=2;
                }
                break;
            case LONG:
                {
                alt24=3;
                }
                break;
            case FLOAT:
                {
                alt24=4;
                }
                break;
            case DOUBLE:
                {
                alt24=5;
                }
                break;
            case DATETIME:
                {
                alt24=6;
                }
                break;
            case CHARARRAY:
                {
                alt24=7;
                }
                break;
            case BYTEARRAY:
                {
                alt24=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:386:4: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN81=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1142); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN81_tree = (CommonTree)adaptor.dupNode(BOOLEAN81);


                    adaptor.addChild(root_0, BOOLEAN81_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BOOLEAN; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:387:4: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT82=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1149); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT82_tree = (CommonTree)adaptor.dupNode(INT82);


                    adaptor.addChild(root_0, INT82_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.INTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:388:4: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG83=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1156); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG83_tree = (CommonTree)adaptor.dupNode(LONG83);


                    adaptor.addChild(root_0, LONG83_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.LONG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:389:4: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT84=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1163); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT84_tree = (CommonTree)adaptor.dupNode(FLOAT84);


                    adaptor.addChild(root_0, FLOAT84_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.FLOAT; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:390:4: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE85=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1170); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE85_tree = (CommonTree)adaptor.dupNode(DOUBLE85);


                    adaptor.addChild(root_0, DOUBLE85_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.DOUBLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:391:4: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME86=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_simple_type1177); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME86_tree = (CommonTree)adaptor.dupNode(DATETIME86);


                    adaptor.addChild(root_0, DATETIME86_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.DATETIME; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:392:4: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY87=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1184); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY87_tree = (CommonTree)adaptor.dupNode(CHARARRAY87);


                    adaptor.addChild(root_0, CHARARRAY87_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.CHARARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:393:4: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY88=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1191); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY88_tree = (CommonTree)adaptor.dupNode(BYTEARRAY88);


                    adaptor.addChild(root_0, BYTEARRAY88_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BYTEARRAY; }

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
    // $ANTLR end "simple_type"


    public static class tuple_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:396:1: tuple_type returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final LogicalPlanGenerator.tuple_type_return tuple_type() throws RecognitionException {
        LogicalPlanGenerator.tuple_type_return retval = new LogicalPlanGenerator.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE89=null;
        LogicalPlanGenerator.field_def_list_return field_def_list90 =null;


        CommonTree TUPLE_TYPE89_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:397:2: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:397:4: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE89=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1208); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE89_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE89);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE89_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:398:7: ( field_def_list )?
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0 >= FIELD_DEF && LA25_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt25=1;
                }
                switch (alt25) {
                    case 1 :
                        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:398:9: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1219);
                        field_def_list90=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list90.getTree());


                        if ( state.backtracking==0 ) { 
                                    LogicalPlanBuilder.setBytearrayForNULLType((field_def_list90!=null?field_def_list90.schema:null));
                                    retval.logicalSchema = (field_def_list90!=null?field_def_list90.schema:null);
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
    // $ANTLR end "tuple_type"


    public static class bag_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:407:1: bag_type returns [LogicalSchema logicalSchema] : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final LogicalPlanGenerator.bag_type_return bag_type() throws RecognitionException {
        LogicalPlanGenerator.bag_type_return retval = new LogicalPlanGenerator.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE91=null;
        CommonTree IDENTIFIER92=null;
        LogicalPlanGenerator.tuple_type_return tuple_type93 =null;


        CommonTree BAG_TYPE91_tree=null;
        CommonTree IDENTIFIER92_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:408:2: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:408:4: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE91=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1259); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE91_tree = (CommonTree)adaptor.dupNode(BAG_TYPE91);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE91_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:408:16: ( IDENTIFIER )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==IDENTIFIER) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:408:16: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER92=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1261); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER92_tree = (CommonTree)adaptor.dupNode(IDENTIFIER92);


                        adaptor.addChild(root_1, IDENTIFIER92_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:408:28: ( tuple_type )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==TUPLE_TYPE) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:408:28: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1264);
                        tuple_type93=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type93.getTree());


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
                   if ((tuple_type93!=null?tuple_type93.logicalSchema:null)!=null && (tuple_type93!=null?tuple_type93.logicalSchema:null).size()==1 && (tuple_type93!=null?tuple_type93.logicalSchema:null).getField(0).type==DataType.TUPLE) {
                       retval.logicalSchema = (tuple_type93!=null?tuple_type93.logicalSchema:null);
                   }
                   else {
                       LogicalSchema s = new LogicalSchema();
                       s.addField(new LogicalFieldSchema((IDENTIFIER92!=null?IDENTIFIER92.getText():null), (tuple_type93!=null?tuple_type93.logicalSchema:null), DataType.TUPLE));
                       retval.logicalSchema = s;
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
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:421:1: map_type returns [LogicalSchema logicalSchema] : ^( MAP_TYPE ( type )? ) ;
    public final LogicalPlanGenerator.map_type_return map_type() throws RecognitionException {
        LogicalPlanGenerator.map_type_return retval = new LogicalPlanGenerator.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE94=null;
        LogicalPlanGenerator.type_return type95 =null;


        CommonTree MAP_TYPE94_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:422:2: ( ^( MAP_TYPE ( type )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:422:4: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE94=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1287); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE94_tree = (CommonTree)adaptor.dupNode(MAP_TYPE94);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE94_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:422:16: ( type )?
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==BOOLEAN||LA28_0==BYTEARRAY||LA28_0==CHARARRAY||LA28_0==DATETIME||LA28_0==DOUBLE||LA28_0==FLOAT||LA28_0==INT||LA28_0==LONG||LA28_0==BAG_TYPE||LA28_0==MAP_TYPE||LA28_0==TUPLE_TYPE) ) {
                    alt28=1;
                }
                switch (alt28) {
                    case 1 :
                        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:422:16: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1289);
                        type95=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type95.getTree());


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
                   LogicalSchema s = null;
                   if( (type95!=null?type95.datatype:null) != null ) {
                       s = new LogicalSchema();
                       s.addField( new LogicalFieldSchema( null, (type95!=null?type95.logicalSchema:null), (type95!=null?type95.datatype:null) ) );
                   }
                   retval.logicalSchema = s;
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
        public FuncSpec funcSpec;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:433:1: func_clause[byte ft] returns [FuncSpec funcSpec] : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final LogicalPlanGenerator.func_clause_return func_clause(byte ft) throws RecognitionException {
        LogicalPlanGenerator.func_clause_return retval = new LogicalPlanGenerator.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF96=null;
        CommonTree FUNC98=null;
        LogicalPlanGenerator.func_name_return func_name97 =null;

        LogicalPlanGenerator.func_name_return func_name99 =null;

        LogicalPlanGenerator.func_args_return func_args100 =null;


        CommonTree FUNC_REF96_tree=null;
        CommonTree FUNC98_tree=null;


            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:437:2: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==FUNC_REF) ) {
                alt30=1;
            }
            else if ( (LA30_0==FUNC) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }
            switch (alt30) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:437:4: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF96=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1318); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF96_tree = (CommonTree)adaptor.dupNode(FUNC_REF96);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF96_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1320);
                    func_name97=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name97.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.funcSpec = builder.lookupFunction( (func_name97!=null?func_name97.funcName:null) );
                           if( retval.funcSpec == null )
                               retval.funcSpec = builder.buildFuncSpec( loc, (func_name97!=null?func_name97.funcName:null), new ArrayList<String>(), ft );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:443:4: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC98=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1334); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC98_tree = (CommonTree)adaptor.dupNode(FUNC98);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC98_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1336);
                    func_name99=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name99.getTree());


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:443:22: ( func_args )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==MULTILINE_QUOTEDSTRING||LA29_0==QUOTEDSTRING) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:443:22: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1338);
                            func_args100=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args100.getTree());


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
                           retval.funcSpec = builder.lookupFunction( (func_name99!=null?func_name99.funcName:null) );
                           if( retval.funcSpec == null ) {
                               List<String> argList = new ArrayList<String>();
                               if( (func_args100!=null?func_args100.args:null) != null )
                                   argList = (func_args100!=null?func_args100.args:null);
                               retval.funcSpec = builder.buildFuncSpec( loc, (func_name99!=null?func_name99.funcName:null), argList, ft );
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
    // $ANTLR end "func_clause"


    public static class func_name_return extends TreeRuleReturnScope {
        public String funcName;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_name"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:455:1: func_name returns [String funcName] : p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* ;
    public final LogicalPlanGenerator.func_name_return func_name() throws RecognitionException {
        LogicalPlanGenerator.func_name_return retval = new LogicalPlanGenerator.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD101=null;
        CommonTree DOLLAR102=null;
        LogicalPlanGenerator.eid_return p1 =null;

        LogicalPlanGenerator.eid_return p2 =null;


        CommonTree PERIOD101_tree=null;
        CommonTree DOLLAR102_tree=null;

         StringBuilder buf = new StringBuilder(); 
        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:457:2: (p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:457:4: p1= eid ( ( PERIOD | DOLLAR ) p2= eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1369);
            p1=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, p1.getTree());


            if ( state.backtracking==0 ) { buf.append( (p1!=null?p1.id:null) ); }

            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:458:7: ( ( PERIOD | DOLLAR ) p2= eid )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==DOLLAR||LA32_0==PERIOD) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:458:9: ( PERIOD | DOLLAR ) p2= eid
            	    {
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:458:9: ( PERIOD | DOLLAR )
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==PERIOD) ) {
            	        alt31=1;
            	    }
            	    else if ( (LA31_0==DOLLAR) ) {
            	        alt31=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 31, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt31) {
            	        case 1 :
            	            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:458:11: PERIOD
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            PERIOD101=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_func_name1383); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PERIOD101_tree = (CommonTree)adaptor.dupNode(PERIOD101);


            	            adaptor.addChild(root_0, PERIOD101_tree);
            	            }


            	            if ( state.backtracking==0 ) { buf.append( (PERIOD101!=null?PERIOD101.getText():null) ); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;
            	        case 2 :
            	            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:458:52: DOLLAR
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            DOLLAR102=(CommonTree)match(input,DOLLAR,FOLLOW_DOLLAR_in_func_name1389); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DOLLAR102_tree = (CommonTree)adaptor.dupNode(DOLLAR102);


            	            adaptor.addChild(root_0, DOLLAR102_tree);
            	            }


            	            if ( state.backtracking==0 ) { buf.append( (DOLLAR102!=null?DOLLAR102.getText():null) ); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;

            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1405);
            	    p2=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, p2.getTree());


            	    if ( state.backtracking==0 ) { buf.append( (p2!=null?p2.id:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            if ( state.backtracking==0 ) {
                   retval.funcName = buf.toString();
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
    // $ANTLR end "func_name"


    public static class func_args_return extends TreeRuleReturnScope {
        public List<String> args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:465:1: func_args returns [List<String> args] : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ ;
    public final LogicalPlanGenerator.func_args_return func_args() throws RecognitionException {
        LogicalPlanGenerator.func_args_return retval = new LogicalPlanGenerator.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING103=null;
        CommonTree MULTILINE_QUOTEDSTRING104=null;

        CommonTree QUOTEDSTRING103_tree=null;
        CommonTree MULTILINE_QUOTEDSTRING104_tree=null;

         retval.args = new ArrayList<String>(); 
        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:467:3: ( ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:467:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:467:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
            int cnt33=0;
            loop33:
            do {
                int alt33=3;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==QUOTEDSTRING) ) {
                    alt33=1;
                }
                else if ( (LA33_0==MULTILINE_QUOTEDSTRING) ) {
                    alt33=2;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:467:5: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING103=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1434); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING103_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING103);


            	    adaptor.addChild(root_0, QUOTEDSTRING103_tree);
            	    }


            	    if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (QUOTEDSTRING103!=null?QUOTEDSTRING103.getText():null) ) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:468:7: MULTILINE_QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    MULTILINE_QUOTEDSTRING104=(CommonTree)match(input,MULTILINE_QUOTEDSTRING,FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1445); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MULTILINE_QUOTEDSTRING104_tree = (CommonTree)adaptor.dupNode(MULTILINE_QUOTEDSTRING104);


            	    adaptor.addChild(root_0, MULTILINE_QUOTEDSTRING104_tree);
            	    }


            	    if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (MULTILINE_QUOTEDSTRING104!=null?MULTILINE_QUOTEDSTRING104.getText():null) ) ); }

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
    // $ANTLR end "func_args"


    protected static class cube_clause_scope {
        LOCube cubeOp;
        MultiMap<Integer, LogicalExpressionPlan> cubePlans;
        List<String> operations;
        int inputIndex;
    }
    protected Stack cube_clause_stack = new Stack();


    public static class cube_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:478:1: cube_clause returns [String alias] : ^( CUBE cube_item ) ;
    public final LogicalPlanGenerator.cube_clause_return cube_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        cube_clause_stack.push(new cube_clause_scope());
        LogicalPlanGenerator.cube_clause_return retval = new LogicalPlanGenerator.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE105=null;
        LogicalPlanGenerator.cube_item_return cube_item106 =null;


        CommonTree CUBE105_tree=null;


            ((cube_clause_scope)cube_clause_stack.peek()).cubeOp = builder.createCubeOp();
            ((GScope_scope)GScope_stack.peek()).currentOp = ((cube_clause_scope)cube_clause_stack.peek()).cubeOp;
            ((cube_clause_scope)cube_clause_stack.peek()).cubePlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((cube_clause_scope)cube_clause_stack.peek()).operations = new ArrayList<String>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:492:2: ( ^( CUBE cube_item ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:492:4: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE105=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1487); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE105_tree = (CommonTree)adaptor.dupNode(CUBE105);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE105_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1489);
            cube_item106=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item106.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                   retval.alias = builder.buildCubeOp( loc, ((cube_clause_scope)cube_clause_stack.peek()).cubeOp, ((statement_scope)statement_stack.peek()).alias, 
                   ((statement_scope)statement_stack.peek()).inputAlias, ((cube_clause_scope)cube_clause_stack.peek()).operations, ((cube_clause_scope)cube_clause_stack.peek()).cubePlans );
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
            GScope_stack.pop();
            cube_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "cube_clause"


    public static class cube_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_item"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:500:1: cube_item : rel ( cube_by_clause ) ;
    public final LogicalPlanGenerator.cube_item_return cube_item() throws RecognitionException {
        LogicalPlanGenerator.cube_item_return retval = new LogicalPlanGenerator.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.rel_return rel107 =null;

        LogicalPlanGenerator.cube_by_clause_return cube_by_clause108 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:501:2: ( rel ( cube_by_clause ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:501:4: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1506);
            rel107=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel107.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:501:8: ( cube_by_clause )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:501:10: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1510);
            cube_by_clause108=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause108.getTree());


            if ( state.backtracking==0 ) { 
                   ((cube_clause_scope)cube_clause_stack.peek()).cubePlans = (cube_by_clause108!=null?cube_by_clause108.plans:null);
                   ((cube_clause_scope)cube_clause_stack.peek()).operations = (cube_by_clause108!=null?cube_by_clause108.operations:null);
               }

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
        public List<String> operations;
        public MultiMap<Integer, LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:508:1: cube_by_clause returns [List<String> operations, MultiMap<Integer, LogicalExpressionPlan> plans] : ^( BY cube_or_rollup ) ;
    public final LogicalPlanGenerator.cube_by_clause_return cube_by_clause() throws RecognitionException {
        LogicalPlanGenerator.cube_by_clause_return retval = new LogicalPlanGenerator.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY109=null;
        LogicalPlanGenerator.cube_or_rollup_return cube_or_rollup110 =null;


        CommonTree BY109_tree=null;


            retval.operations = new ArrayList<String>();
            retval.plans = new MultiMap<Integer, LogicalExpressionPlan>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:513:2: ( ^( BY cube_or_rollup ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:513:4: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY109=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1538); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY109_tree = (CommonTree)adaptor.dupNode(BY109);


            root_1 = (CommonTree)adaptor.becomeRoot(BY109_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1540);
            cube_or_rollup110=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup110.getTree());


            if ( state.backtracking==0 ) { retval.operations = (cube_or_rollup110!=null?cube_or_rollup110.operations:null); retval.plans = (cube_or_rollup110!=null?cube_or_rollup110.plans:null); }

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
        public List<String> operations;
        public MultiMap<Integer, LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_or_rollup"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:516:1: cube_or_rollup returns [List<String> operations, MultiMap<Integer, LogicalExpressionPlan> plans] : ( cube_rollup_list )+ ;
    public final LogicalPlanGenerator.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        LogicalPlanGenerator.cube_or_rollup_return retval = new LogicalPlanGenerator.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.cube_rollup_list_return cube_rollup_list111 =null;




            retval.operations = new ArrayList<String>();
            retval.plans = new MultiMap<Integer, LogicalExpressionPlan>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:521:2: ( ( cube_rollup_list )+ )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:521:4: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:521:4: ( cube_rollup_list )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==CUBE||LA34_0==ROLLUP) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:521:6: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1563);
            	    cube_rollup_list111=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list111.getTree());


            	    if ( state.backtracking==0 ) { 
            	           retval.operations.add((cube_rollup_list111!=null?cube_rollup_list111.operation:null)); 
            	           retval.plans.put( ((cube_clause_scope)cube_clause_stack.peek()).inputIndex, (cube_rollup_list111!=null?cube_rollup_list111.plans:null)); 
            	           ((cube_clause_scope)cube_clause_stack.peek()).inputIndex++;
            	       }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
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
        public String operation;
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_rollup_list"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:529:1: cube_rollup_list returns [String operation, List<LogicalExpressionPlan> plans] : ^( ( CUBE | ROLLUP ) cube_by_expr_list ) ;
    public final LogicalPlanGenerator.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        LogicalPlanGenerator.cube_rollup_list_return retval = new LogicalPlanGenerator.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE112=null;
        CommonTree ROLLUP113=null;
        LogicalPlanGenerator.cube_by_expr_list_return cube_by_expr_list114 =null;


        CommonTree CUBE112_tree=null;
        CommonTree ROLLUP113_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:533:2: ( ^( ( CUBE | ROLLUP ) cube_by_expr_list ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:533:4: ^( ( CUBE | ROLLUP ) cube_by_expr_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:533:7: ( CUBE | ROLLUP )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==CUBE) ) {
                alt35=1;
            }
            else if ( (LA35_0==ROLLUP) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:533:9: CUBE
                    {
                    _last = (CommonTree)input.LT(1);
                    CUBE112=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_rollup_list1594); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE112_tree = (CommonTree)adaptor.dupNode(CUBE112);


                    adaptor.addChild(root_1, CUBE112_tree);
                    }


                    if ( state.backtracking==0 ) { retval.operation = "CUBE"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:533:41: ROLLUP
                    {
                    _last = (CommonTree)input.LT(1);
                    ROLLUP113=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_cube_rollup_list1600); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP113_tree = (CommonTree)adaptor.dupNode(ROLLUP113);


                    adaptor.addChild(root_1, ROLLUP113_tree);
                    }


                    if ( state.backtracking==0 ) { retval.operation = "ROLLUP"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1606);
            cube_by_expr_list114=cube_by_expr_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_by_expr_list114.getTree());


            if ( state.backtracking==0 ) { retval.plans = (cube_by_expr_list114!=null?cube_by_expr_list114.plans:null); }

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
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr_list"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:536:1: cube_by_expr_list returns [List<LogicalExpressionPlan> plans] : ( cube_by_expr )+ ;
    public final LogicalPlanGenerator.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        LogicalPlanGenerator.cube_by_expr_list_return retval = new LogicalPlanGenerator.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.cube_by_expr_return cube_by_expr115 =null;




            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:540:2: ( ( cube_by_expr )+ )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:540:4: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:540:4: ( cube_by_expr )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==CUBE||LA36_0==DIV||LA36_0==DOLLARVAR||LA36_0==DOUBLENUMBER||LA36_0==FALSE||LA36_0==FLOATNUMBER||LA36_0==GROUP||LA36_0==INTEGER||LA36_0==LONGINTEGER||LA36_0==MINUS||LA36_0==PERCENT||LA36_0==PLUS||LA36_0==QUOTEDSTRING||LA36_0==STAR||LA36_0==TRUE||(LA36_0 >= BAG_VAL && LA36_0 <= BIN_EXPR)||(LA36_0 >= CAST_EXPR && LA36_0 <= EXPR_IN_PAREN)||LA36_0==FUNC_EVAL||LA36_0==IDENTIFIER||(LA36_0 >= MAP_VAL && LA36_0 <= NEG)||LA36_0==NULL||LA36_0==TUPLE_VAL) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:540:6: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1631);
            	    cube_by_expr115=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr115.getTree());


            	    if ( state.backtracking==0 ) { retval.plans.add( (cube_by_expr115!=null?cube_by_expr115.plan:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
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
        public LogicalExpressionPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:543:1: cube_by_expr returns [LogicalExpressionPlan plan] : ( col_range[$plan] | expr[$plan] | STAR );
    public final LogicalPlanGenerator.cube_by_expr_return cube_by_expr() throws RecognitionException {
        LogicalPlanGenerator.cube_by_expr_return retval = new LogicalPlanGenerator.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR118=null;
        LogicalPlanGenerator.col_range_return col_range116 =null;

        LogicalPlanGenerator.expr_return expr117 =null;


        CommonTree STAR118_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:547:2: ( col_range[$plan] | expr[$plan] | STAR )
            int alt37=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt37=1;
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
                alt37=2;
                }
                break;
            case STAR:
                {
                int LA37_3 = input.LA(2);

                if ( (LA37_3==DOWN) ) {
                    alt37=2;
                }
                else if ( (LA37_3==EOF||LA37_3==UP||LA37_3==CUBE||LA37_3==DIV||LA37_3==DOLLARVAR||LA37_3==DOUBLENUMBER||LA37_3==FALSE||LA37_3==FLOATNUMBER||LA37_3==GROUP||LA37_3==INTEGER||LA37_3==LONGINTEGER||LA37_3==MINUS||LA37_3==PERCENT||LA37_3==PLUS||LA37_3==QUOTEDSTRING||LA37_3==STAR||LA37_3==TRUE||(LA37_3 >= BAG_VAL && LA37_3 <= BIN_EXPR)||(LA37_3 >= CAST_EXPR && LA37_3 <= EXPR_IN_PAREN)||LA37_3==FUNC_EVAL||LA37_3==IDENTIFIER||(LA37_3 >= MAP_VAL && LA37_3 <= NEG)||LA37_3==NULL||LA37_3==TUPLE_VAL) ) {
                    alt37=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }

            switch (alt37) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:547:4: col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1654);
                    col_range116=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range116.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:548:4: expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1660);
                    expr117=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr117.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:549:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR118=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1666); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR118_tree = (CommonTree)adaptor.dupNode(STAR118);


                    adaptor.addChild(root_0, STAR118_tree);
                    }


                    if ( state.backtracking==0 ) {
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR118 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp, 0, null, -1 );
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


    protected static class group_clause_scope {
        MultiMap<Integer, LogicalExpressionPlan> groupPlans;
        int inputIndex;
        List<String> inputAliases;
        List<Boolean> innerFlags;
    }
    protected Stack group_clause_stack = new Stack();


    public static class group_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:555:1: group_clause returns [String alias] : ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) );
    public final LogicalPlanGenerator.group_clause_return group_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        group_clause_stack.push(new group_clause_scope());
        LogicalPlanGenerator.group_clause_return retval = new LogicalPlanGenerator.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP119=null;
        CommonTree COGROUP123=null;
        LogicalPlanGenerator.group_item_return group_item120 =null;

        LogicalPlanGenerator.group_type_return group_type121 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause122 =null;

        LogicalPlanGenerator.group_item_return group_item124 =null;

        LogicalPlanGenerator.group_type_return group_type125 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause126 =null;


        CommonTree GROUP119_tree=null;
        CommonTree COGROUP123_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createGroupOp(); 
            ((group_clause_scope)group_clause_stack.peek()).groupPlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((group_clause_scope)group_clause_stack.peek()).inputAliases = new ArrayList<String>();
            ((group_clause_scope)group_clause_stack.peek()).innerFlags = new ArrayList<Boolean>();
            GROUPTYPE groupType = GROUPTYPE.REGULAR;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
            int oldStatementIndex = ((statement_scope)statement_stack.peek()).inputIndex;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:573:2: ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==GROUP) ) {
                alt44=1;
            }
            else if ( (LA44_0==COGROUP) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }
            switch (alt44) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:573:4: ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    GROUP119=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_group_clause1706); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP119_tree = (CommonTree)adaptor.dupNode(GROUP119);


                    root_1 = (CommonTree)adaptor.becomeRoot(GROUP119_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:573:13: ( group_item )+
                    int cnt38=0;
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==COGROUP||(LA38_0 >= CROSS && LA38_0 <= CUBE)||LA38_0==DEFINE||LA38_0==DISTINCT||LA38_0==FILTER||LA38_0==FOREACH||LA38_0==GROUP||LA38_0==JOIN||(LA38_0 >= LIMIT && LA38_0 <= LOAD)||LA38_0==MAPREDUCE||LA38_0==ORDER||LA38_0==RANK||LA38_0==SAMPLE||(LA38_0 >= STORE && LA38_0 <= STREAM)||LA38_0==UNION||LA38_0==IDENTIFIER) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:573:13: group_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_group_item_in_group_clause1708);
                    	    group_item120=group_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, group_item120.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt38 >= 1 ) break loop38;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(38, input);
                                throw eee;
                        }
                        cnt38++;
                    } while (true);


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:573:25: ( group_type )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==QUOTEDSTRING) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:573:27: group_type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_group_type_in_group_clause1713);
                            group_type121=group_type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, group_type121.getTree());


                            if ( state.backtracking==0 ) { groupType = (group_type121!=null?group_type121.type:null); ((LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:573:146: ( partition_clause )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==PARTITION) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:573:146: partition_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_partition_clause_in_group_clause1720);
                            partition_clause122=partition_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, partition_clause122.getTree());


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
                           retval.alias = builder.buildGroupOp( loc, (LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, 
                               ((group_clause_scope)group_clause_stack.peek()).inputAliases, ((group_clause_scope)group_clause_stack.peek()).groupPlans, groupType, ((group_clause_scope)group_clause_stack.peek()).innerFlags,
                               (partition_clause122!=null?partition_clause122.partitioner:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:579:4: ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    COGROUP123=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_group_clause1735); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP123_tree = (CommonTree)adaptor.dupNode(COGROUP123);


                    root_1 = (CommonTree)adaptor.becomeRoot(COGROUP123_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:579:15: ( group_item )+
                    int cnt41=0;
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==COGROUP||(LA41_0 >= CROSS && LA41_0 <= CUBE)||LA41_0==DEFINE||LA41_0==DISTINCT||LA41_0==FILTER||LA41_0==FOREACH||LA41_0==GROUP||LA41_0==JOIN||(LA41_0 >= LIMIT && LA41_0 <= LOAD)||LA41_0==MAPREDUCE||LA41_0==ORDER||LA41_0==RANK||LA41_0==SAMPLE||(LA41_0 >= STORE && LA41_0 <= STREAM)||LA41_0==UNION||LA41_0==IDENTIFIER) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:579:15: group_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_group_item_in_group_clause1737);
                    	    group_item124=group_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, group_item124.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt41 >= 1 ) break loop41;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(41, input);
                                throw eee;
                        }
                        cnt41++;
                    } while (true);


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:579:27: ( group_type )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==QUOTEDSTRING) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:579:29: group_type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_group_type_in_group_clause1742);
                            group_type125=group_type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, group_type125.getTree());


                            if ( state.backtracking==0 ) { groupType = (group_type125!=null?group_type125.type:null);((LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:579:147: ( partition_clause )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==PARTITION) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:579:147: partition_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_partition_clause_in_group_clause1749);
                            partition_clause126=partition_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, partition_clause126.getTree());


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
                           retval.alias = builder.buildGroupOp( loc, (LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, 
                               ((group_clause_scope)group_clause_stack.peek()).inputAliases, ((group_clause_scope)group_clause_stack.peek()).groupPlans, groupType, ((group_clause_scope)group_clause_stack.peek()).innerFlags,
                               (partition_clause126!=null?partition_clause126.partitioner:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).inputIndex = oldStatementIndex; }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            group_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        public GROUPTYPE type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:587:1: group_type returns [GROUPTYPE type] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.group_type_return group_type() throws RecognitionException {
        LogicalPlanGenerator.group_type_return retval = new LogicalPlanGenerator.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING127=null;

        CommonTree QUOTEDSTRING127_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:588:2: ( QUOTEDSTRING )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:588:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING127=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1770); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING127_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING127);


            adaptor.addChild(root_0, QUOTEDSTRING127_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.type =builder.parseGroupType( (QUOTEDSTRING127!=null?QUOTEDSTRING127.getText():null), new SourceLocation( (PigParserNode)QUOTEDSTRING127 ) );
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:594:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final LogicalPlanGenerator.group_item_return group_item() throws RecognitionException {
        LogicalPlanGenerator.group_item_return retval = new LogicalPlanGenerator.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL130=null;
        CommonTree ANY131=null;
        CommonTree INNER132=null;
        CommonTree OUTER133=null;
        LogicalPlanGenerator.rel_return rel128 =null;

        LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause129 =null;


        CommonTree ALL130_tree=null;
        CommonTree ANY131_tree=null;
        CommonTree INNER132_tree=null;
        CommonTree OUTER133_tree=null;

         boolean inner = false; 
        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:596:2: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:596:4: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1791);
            rel128=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel128.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:596:8: ( join_group_by_clause | ALL | ANY )
            int alt45=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt45=1;
                }
                break;
            case ALL:
                {
                alt45=2;
                }
                break;
            case ANY:
                {
                alt45=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }

            switch (alt45) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:596:10: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1795);
                    join_group_by_clause129=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause129.getTree());


                    if ( state.backtracking==0 ) { 
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, (join_group_by_clause129!=null?join_group_by_clause129.plans:null) );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:600:12: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL130=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1820); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL130_tree = (CommonTree)adaptor.dupNode(ALL130);


                    adaptor.addChild(root_0, ALL130_tree);
                    }


                    if ( state.backtracking==0 ) {
                                 LogicalExpressionPlan plan = new LogicalExpressionPlan();
                                 ConstantExpression ce = new ConstantExpression( plan, "all");
                                 ce.setLocation( new SourceLocation( (PigParserNode)ALL130 ) );
                                 List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>( 1 );
                                 plans.add( plan );
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, plans );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:609:12: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY131=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1845); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY131_tree = (CommonTree)adaptor.dupNode(ANY131);


                    adaptor.addChild(root_0, ANY131_tree);
                    }


                    if ( state.backtracking==0 ) {
                                 LogicalExpressionPlan plan = new LogicalExpressionPlan();
                                 UserFuncExpression udf = new UserFuncExpression( plan, new FuncSpec( GFAny.class.getName() ) );
                                 udf.setLocation( new SourceLocation( (PigParserNode)ANY131 ) );
                                 List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>( 1 );
                                 plans.add( plan );
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, plans );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:618:11: ( INNER | OUTER )?
            int alt46=3;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==INNER) ) {
                alt46=1;
            }
            else if ( (LA46_0==OUTER) ) {
                alt46=2;
            }
            switch (alt46) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:618:13: INNER
                    {
                    _last = (CommonTree)input.LT(1);
                    INNER132=(CommonTree)match(input,INNER,FOLLOW_INNER_in_group_item1870); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER132_tree = (CommonTree)adaptor.dupNode(INNER132);


                    adaptor.addChild(root_0, INNER132_tree);
                    }


                    if ( state.backtracking==0 ) { inner =  true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:618:40: OUTER
                    {
                    _last = (CommonTree)input.LT(1);
                    OUTER133=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_group_item1876); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER133_tree = (CommonTree)adaptor.dupNode(OUTER133);


                    adaptor.addChild(root_0, OUTER133_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                   ((group_clause_scope)group_clause_stack.peek()).inputAliases.add( ((statement_scope)statement_stack.peek()).inputAlias );
                   ((group_clause_scope)group_clause_stack.peek()).innerFlags.add( inner );
                   ((group_clause_scope)group_clause_stack.peek()).inputIndex++;
                   ((statement_scope)statement_stack.peek()).inputIndex++;
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:627:1: rel : ( alias | inline_op );
    public final LogicalPlanGenerator.rel_return rel() throws RecognitionException {
        LogicalPlanGenerator.rel_return retval = new LogicalPlanGenerator.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.alias_return alias134 =null;

        LogicalPlanGenerator.inline_op_return inline_op135 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:628:2: ( alias | inline_op )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==IDENTIFIER) ) {
                alt47=1;
            }
            else if ( (LA47_0==COGROUP||(LA47_0 >= CROSS && LA47_0 <= CUBE)||LA47_0==DEFINE||LA47_0==DISTINCT||LA47_0==FILTER||LA47_0==FOREACH||LA47_0==GROUP||LA47_0==JOIN||(LA47_0 >= LIMIT && LA47_0 <= LOAD)||LA47_0==MAPREDUCE||LA47_0==ORDER||LA47_0==RANK||LA47_0==SAMPLE||(LA47_0 >= STORE && LA47_0 <= STREAM)||LA47_0==UNION) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }
            switch (alt47) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:628:4: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1894);
                    alias134=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias134.getTree());


                    if ( state.backtracking==0 ) {
                           ((statement_scope)statement_stack.peek()).inputAlias = (alias134!=null?alias134.name:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:632:4: inline_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_inline_op_in_rel1904);
                    inline_op135=inline_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, inline_op135.getTree());


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


    public static class inline_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "inline_op"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:635:1: inline_op : op_clause ( parallel_clause )? ;
    public final LogicalPlanGenerator.inline_op_return inline_op() throws RecognitionException {
        LogicalPlanGenerator.inline_op_return retval = new LogicalPlanGenerator.inline_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.op_clause_return op_clause136 =null;

        LogicalPlanGenerator.parallel_clause_return parallel_clause137 =null;




            String al = ((statement_scope)statement_stack.peek()).alias;
            ((statement_scope)statement_stack.peek()).alias = null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:643:2: ( op_clause ( parallel_clause )? )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:643:4: op_clause ( parallel_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_inline_op1924);
            op_clause136=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, op_clause136.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:643:14: ( parallel_clause )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==PARALLEL) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:643:14: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_inline_op1926);
                    parallel_clause137=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, parallel_clause137.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                   Operator op = builder.lookupOperator( (op_clause136!=null?op_clause136.alias:null) );
                   builder.setParallel( (LogicalRelationalOperator)op, ((statement_scope)statement_stack.peek()).parallel );
                   ((statement_scope)statement_stack.peek()).inputAlias = (op_clause136!=null?op_clause136.alias:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
                ((statement_scope)statement_stack.peek()).alias = al;
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
    // $ANTLR end "inline_op"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        public boolean flattenFlag;
        public LogicalSchema schema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:651:1: flatten_generated_item returns [LogicalExpressionPlan plan, boolean flattenFlag, LogicalSchema schema] : ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? ;
    public final LogicalPlanGenerator.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        LogicalPlanGenerator.flatten_generated_item_return retval = new LogicalPlanGenerator.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR141=null;
        LogicalPlanGenerator.flatten_clause_return flatten_clause138 =null;

        LogicalPlanGenerator.col_range_return col_range139 =null;

        LogicalPlanGenerator.expr_return expr140 =null;

        LogicalPlanGenerator.field_def_list_return field_def_list142 =null;


        CommonTree STAR141_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:655:2: ( ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:655:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:655:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR )
            int alt49=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt49=1;
                }
                break;
            case COL_RANGE:
                {
                alt49=2;
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
                alt49=3;
                }
                break;
            case STAR:
                {
                int LA49_4 = input.LA(2);

                if ( (LA49_4==DOWN) ) {
                    alt49=3;
                }
                else if ( (LA49_4==EOF||LA49_4==UP||LA49_4==CUBE||LA49_4==DIV||LA49_4==DOLLARVAR||LA49_4==DOUBLENUMBER||LA49_4==FALSE||LA49_4==FLATTEN||LA49_4==FLOATNUMBER||LA49_4==GROUP||LA49_4==INTEGER||LA49_4==LONGINTEGER||LA49_4==MINUS||LA49_4==PERCENT||LA49_4==PLUS||LA49_4==QUOTEDSTRING||LA49_4==STAR||LA49_4==TRUE||(LA49_4 >= BAG_VAL && LA49_4 <= BIN_EXPR)||(LA49_4 >= CAST_EXPR && LA49_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA49_4==FUNC_EVAL||LA49_4==IDENTIFIER||(LA49_4 >= MAP_VAL && LA49_4 <= NEG)||LA49_4==NULL||LA49_4==TUPLE_VAL) ) {
                    alt49=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 4, input);

                    throw nvae;

                }
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
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:655:6: flatten_clause[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1952);
                    flatten_clause138=flatten_clause(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause138.getTree());


                    if ( state.backtracking==0 ) { retval.flattenFlag = true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:656:6: col_range[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1962);
                    col_range139=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range139.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:657:6: expr[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1970);
                    expr140=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr140.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:658:6: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR141=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1978); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR141_tree = (CommonTree)adaptor.dupNode(STAR141);


                    adaptor.addChild(root_0, STAR141_tree);
                    }


                    if ( state.backtracking==0 ) {
                             builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR141 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                 ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:664:4: ( field_def_list )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0 >= FIELD_DEF && LA50_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:664:6: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1997);
                    field_def_list142=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list142.getTree());


                    if ( state.backtracking==0 ) { retval.schema = (field_def_list142!=null?field_def_list142.schema:null); }

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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:667:1: flatten_clause[LogicalExpressionPlan plan] : ^( FLATTEN expr[$plan] ) ;
    public final LogicalPlanGenerator.flatten_clause_return flatten_clause(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.flatten_clause_return retval = new LogicalPlanGenerator.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN143=null;
        LogicalPlanGenerator.expr_return expr144 =null;


        CommonTree FLATTEN143_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:668:2: ( ^( FLATTEN expr[$plan] ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:668:4: ^( FLATTEN expr[$plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN143=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause2015); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN143_tree = (CommonTree)adaptor.dupNode(FLATTEN143);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN143_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause2017);
            expr144=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr144.getTree());


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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "store_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:671:1: store_clause returns [String alias] : ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) ;
    public final LogicalPlanGenerator.store_clause_return store_clause() throws RecognitionException {
        LogicalPlanGenerator.store_clause_return retval = new LogicalPlanGenerator.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE145=null;
        LogicalPlanGenerator.rel_return rel146 =null;

        LogicalPlanGenerator.filename_return filename147 =null;

        LogicalPlanGenerator.func_clause_return func_clause148 =null;


        CommonTree STORE145_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:672:2: ( ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:672:4: ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE145=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause2035); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE145_tree = (CommonTree)adaptor.dupNode(STORE145);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE145_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause2037);
            rel146=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel146.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause2039);
            filename147=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename147.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:672:26: ( func_clause[FunctionType.STOREFUNC] )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==FUNC||LA51_0==FUNC_REF) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:672:26: func_clause[FunctionType.STOREFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause2041);
                    func_clause148=func_clause(FunctionType.STOREFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause148.getTree());


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
                   SourceLocation loc = new SourceLocation( (PigParserNode)STORE145 );
                   retval.alias = builder.buildStoreOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (filename147!=null?filename147.filename:null), (func_clause148!=null?func_clause148.funcSpec:null) );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:680:1: filter_clause returns [String alias] : ^( FILTER rel cond[exprPlan] ) ;
    public final LogicalPlanGenerator.filter_clause_return filter_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.filter_clause_return retval = new LogicalPlanGenerator.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER149=null;
        LogicalPlanGenerator.rel_return rel150 =null;

        LogicalPlanGenerator.cond_return cond151 =null;


        CommonTree FILTER149_tree=null;

         
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createFilterOp();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:686:2: ( ^( FILTER rel cond[exprPlan] ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:686:4: ^( FILTER rel cond[exprPlan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER149=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause2075); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER149_tree = (CommonTree)adaptor.dupNode(FILTER149);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER149_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause2077);
            rel150=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel150.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause2079);
            cond151=cond(exprPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond151.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildFilterOp( new SourceLocation( (PigParserNode)FILTER149 ),
                       (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                       ((statement_scope)statement_stack.peek()).inputAlias, exprPlan );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "filter_clause"


    public static class cond_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cond"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:694:1: cond[LogicalExpressionPlan exprPlan] returns [LogicalExpression expr] : ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | func_eval[$exprPlan] | ^( BOOL_COND e1= expr[$exprPlan] ) );
    public final LogicalPlanGenerator.cond_return cond(LogicalExpressionPlan exprPlan) throws RecognitionException {
        LogicalPlanGenerator.cond_return retval = new LogicalPlanGenerator.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR152=null;
        CommonTree AND153=null;
        CommonTree NOT154=null;
        CommonTree NULL155=null;
        CommonTree NOT157=null;
        CommonTree STR_OP_MATCHES164=null;
        CommonTree BOOL_COND166=null;
        LogicalPlanGenerator.cond_return left =null;

        LogicalPlanGenerator.cond_return right =null;

        LogicalPlanGenerator.cond_return c =null;

        LogicalPlanGenerator.expr_return e1 =null;

        LogicalPlanGenerator.expr_return e2 =null;

        LogicalPlanGenerator.expr_return expr156 =null;

        LogicalPlanGenerator.rel_op_eq_return rel_op_eq158 =null;

        LogicalPlanGenerator.rel_op_ne_return rel_op_ne159 =null;

        LogicalPlanGenerator.rel_op_lt_return rel_op_lt160 =null;

        LogicalPlanGenerator.rel_op_lte_return rel_op_lte161 =null;

        LogicalPlanGenerator.rel_op_gt_return rel_op_gt162 =null;

        LogicalPlanGenerator.rel_op_gte_return rel_op_gte163 =null;

        LogicalPlanGenerator.func_eval_return func_eval165 =null;


        CommonTree OR152_tree=null;
        CommonTree AND153_tree=null;
        CommonTree NOT154_tree=null;
        CommonTree NULL155_tree=null;
        CommonTree NOT157_tree=null;
        CommonTree STR_OP_MATCHES164_tree=null;
        CommonTree BOOL_COND166_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:695:2: ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | func_eval[$exprPlan] | ^( BOOL_COND e1= expr[$exprPlan] ) )
            int alt53=13;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt53=1;
                }
                break;
            case AND:
                {
                alt53=2;
                }
                break;
            case NOT:
                {
                alt53=3;
                }
                break;
            case NULL:
                {
                alt53=4;
                }
                break;
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt53=5;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt53=6;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt53=7;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt53=8;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt53=9;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt53=10;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt53=11;
                }
                break;
            case FUNC_EVAL:
                {
                alt53=12;
                }
                break;
            case BOOL_COND:
                {
                alt53=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }

            switch (alt53) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:695:4: ^( OR left= cond[exprPlan] right= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR152=(CommonTree)match(input,OR,FOLLOW_OR_in_cond2103); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR152_tree = (CommonTree)adaptor.dupNode(OR152);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR152_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2109);
                    left=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2116);
                    right=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new OrExpression( exprPlan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)OR152 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:700:4: ^( AND left= cond[exprPlan] right= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND153=(CommonTree)match(input,AND,FOLLOW_AND_in_cond2131); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND153_tree = (CommonTree)adaptor.dupNode(AND153);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND153_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2137);
                    left=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2144);
                    right=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new AndExpression( exprPlan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)AND153 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:705:4: ^( NOT c= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT154=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2159); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT154_tree = (CommonTree)adaptor.dupNode(NOT154);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT154_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2165);
                    c=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, c.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NotExpression( exprPlan, (c!=null?c.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)NOT154 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:710:4: ^( NULL expr[$exprPlan] ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL155=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond2180); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL155_tree = (CommonTree)adaptor.dupNode(NULL155);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL155_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2182);
                    expr156=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr156.getTree());


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:710:28: ( NOT )?
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==NOT) ) {
                        alt52=1;
                    }
                    switch (alt52) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:710:28: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT157=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2185); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT157_tree = (CommonTree)adaptor.dupNode(NOT157);


                            adaptor.addChild(root_1, NOT157_tree);
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
                           retval.expr = new IsNullExpression( exprPlan, (expr156!=null?expr156.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)NULL155 ) );
                           if( NOT157 != null ) {
                               retval.expr = new NotExpression( exprPlan, retval.expr );
                               retval.expr.setLocation( new SourceLocation( (PigParserNode)NOT157 ) );
                           }
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:719:4: ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_cond2200);
                    rel_op_eq158=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_eq158.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2206);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2213);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new EqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_eq158!=null?((CommonTree)rel_op_eq158.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:724:4: ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_cond2229);
                    rel_op_ne159=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_ne159.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2235);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2242);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NotEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_ne159!=null?((CommonTree)rel_op_ne159.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:729:4: ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_cond2258);
                    rel_op_lt160=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lt160.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2264);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2271);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new LessThanExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_lt160!=null?((CommonTree)rel_op_lt160.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:734:4: ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_cond2287);
                    rel_op_lte161=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lte161.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2293);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2300);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new LessThanEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_lte161!=null?((CommonTree)rel_op_lte161.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:739:4: ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_cond2315);
                    rel_op_gt162=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gt162.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2321);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2328);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new GreaterThanExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_gt162!=null?((CommonTree)rel_op_gt162.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:744:4: ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_cond2344);
                    rel_op_gte163=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gte163.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2350);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2357);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new GreaterThanEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_gte163!=null?((CommonTree)rel_op_gte163.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:749:4: ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES164=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_cond2372); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES164_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES164);


                    root_1 = (CommonTree)adaptor.becomeRoot(STR_OP_MATCHES164_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2378);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2385);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new RegexExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)STR_OP_MATCHES164 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:754:4: func_eval[$exprPlan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond2398);
                    func_eval165=func_eval(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval165.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (func_eval165!=null?func_eval165.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:758:4: ^( BOOL_COND e1= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND166=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond2411); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND166_tree = (CommonTree)adaptor.dupNode(BOOL_COND166);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND166_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2417);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                       	   retval.expr = (e1!=null?e1.expr:null);
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)BOOL_COND166 ) );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:766:1: func_eval[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) ;
    public final LogicalPlanGenerator.func_eval_return func_eval(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.func_eval_return retval = new LogicalPlanGenerator.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL167=null;
        LogicalPlanGenerator.func_name_return func_name168 =null;

        LogicalPlanGenerator.real_arg_return real_arg169 =null;


        CommonTree FUNC_EVAL167_tree=null;

         
            List<LogicalExpression> args = new ArrayList<LogicalExpression>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:770:2: ( ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:770:4: ^( FUNC_EVAL func_name ( real_arg[$plan] )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FUNC_EVAL167=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval2450); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNC_EVAL167_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL167);


            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL167_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_func_eval2452);
            func_name168=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name168.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:770:27: ( real_arg[$plan] )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==CUBE||LA54_0==DIV||LA54_0==DOLLARVAR||LA54_0==DOUBLENUMBER||LA54_0==FALSE||LA54_0==FLOATNUMBER||LA54_0==GROUP||LA54_0==INTEGER||LA54_0==LONGINTEGER||LA54_0==MINUS||LA54_0==PERCENT||LA54_0==PLUS||LA54_0==QUOTEDSTRING||LA54_0==STAR||LA54_0==TRUE||(LA54_0 >= BAG_VAL && LA54_0 <= BIN_EXPR)||(LA54_0 >= CAST_EXPR && LA54_0 <= EXPR_IN_PAREN)||LA54_0==FUNC_EVAL||LA54_0==IDENTIFIER||(LA54_0 >= MAP_VAL && LA54_0 <= NEG)||LA54_0==NULL||LA54_0==TUPLE_VAL) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:770:29: real_arg[$plan]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_real_arg_in_func_eval2456);
            	    real_arg169=real_arg(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, real_arg169.getTree());


            	    if ( state.backtracking==0 ) { args.add( (real_arg169!=null?real_arg169.expr:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(func_name168!=null?((CommonTree)func_name168.start):null) );
                   retval.expr = builder.buildUDF( loc, plan, (func_name168!=null?func_name168.funcName:null), args );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:777:1: real_arg[LogicalExpressionPlan plan] returns [LogicalExpression expr] : (e= expr[$plan] | STAR |cr= col_range[$plan] );
    public final LogicalPlanGenerator.real_arg_return real_arg(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.real_arg_return retval = new LogicalPlanGenerator.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR170=null;
        LogicalPlanGenerator.expr_return e =null;

        LogicalPlanGenerator.col_range_return cr =null;


        CommonTree STAR170_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:778:2: (e= expr[$plan] | STAR |cr= col_range[$plan] )
            int alt55=3;
            switch ( input.LA(1) ) {
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
                alt55=1;
                }
                break;
            case STAR:
                {
                int LA55_2 = input.LA(2);

                if ( (LA55_2==DOWN) ) {
                    alt55=1;
                }
                else if ( (LA55_2==EOF||LA55_2==UP||LA55_2==CUBE||LA55_2==DIV||LA55_2==DOLLARVAR||LA55_2==DOUBLENUMBER||LA55_2==FALSE||LA55_2==FLOATNUMBER||LA55_2==GROUP||LA55_2==INTEGER||LA55_2==LONGINTEGER||LA55_2==MINUS||LA55_2==PERCENT||LA55_2==PLUS||LA55_2==QUOTEDSTRING||LA55_2==STAR||LA55_2==TRUE||(LA55_2 >= BAG_VAL && LA55_2 <= BIN_EXPR)||(LA55_2 >= CAST_EXPR && LA55_2 <= EXPR_IN_PAREN)||LA55_2==FUNC_EVAL||LA55_2==IDENTIFIER||(LA55_2 >= MAP_VAL && LA55_2 <= NEG)||LA55_2==NULL||LA55_2==TUPLE_VAL) ) {
                    alt55=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt55=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }

            switch (alt55) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:778:4: e= expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg2488);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (e!=null?e.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:779:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR170=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg2496); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR170_tree = (CommonTree)adaptor.dupNode(STAR170);


                    adaptor.addChild(root_0, STAR170_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR170 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp, 
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:784:4: cr= col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg2510);
                    cr=col_range(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cr.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (cr!=null?cr.expr:null);}

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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:787:1: expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) );
    public final LogicalPlanGenerator.expr_return expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.expr_return retval = new LogicalPlanGenerator.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS171=null;
        CommonTree MINUS172=null;
        CommonTree STAR173=null;
        CommonTree DIV174=null;
        CommonTree PERCENT175=null;
        CommonTree NEG178=null;
        CommonTree CAST_EXPR179=null;
        CommonTree EXPR_IN_PAREN181=null;
        LogicalPlanGenerator.expr_return left =null;

        LogicalPlanGenerator.expr_return right =null;

        LogicalPlanGenerator.expr_return e =null;

        LogicalPlanGenerator.const_expr_return const_expr176 =null;

        LogicalPlanGenerator.var_expr_return var_expr177 =null;

        LogicalPlanGenerator.type_cast_return type_cast180 =null;


        CommonTree PLUS171_tree=null;
        CommonTree MINUS172_tree=null;
        CommonTree STAR173_tree=null;
        CommonTree DIV174_tree=null;
        CommonTree PERCENT175_tree=null;
        CommonTree NEG178_tree=null;
        CommonTree CAST_EXPR179_tree=null;
        CommonTree EXPR_IN_PAREN181_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:788:2: ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) )
            int alt56=10;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt56=1;
                }
                break;
            case MINUS:
                {
                int LA56_2 = input.LA(2);

                if ( (LA56_2==DOWN) ) {
                    alt56=2;
                }
                else if ( (LA56_2==DOUBLENUMBER||LA56_2==FLOATNUMBER||LA56_2==INTEGER||LA56_2==LONGINTEGER) ) {
                    alt56=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt56=3;
                }
                break;
            case DIV:
                {
                alt56=4;
                }
                break;
            case PERCENT:
                {
                alt56=5;
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
                alt56=6;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case BIN_EXPR:
            case FUNC_EVAL:
            case IDENTIFIER:
                {
                alt56=7;
                }
                break;
            case NEG:
                {
                alt56=8;
                }
                break;
            case CAST_EXPR:
                {
                alt56=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt56=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }

            switch (alt56) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:788:4: ^( PLUS left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS171=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr2529); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS171_tree = (CommonTree)adaptor.dupNode(PLUS171);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS171_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2535);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2542);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new AddExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)PLUS171 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:793:4: ^( MINUS left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS172=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr2557); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS172_tree = (CommonTree)adaptor.dupNode(MINUS172);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS172_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2563);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2570);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new SubtractExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)MINUS172 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:798:4: ^( STAR left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR173=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr2585); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR173_tree = (CommonTree)adaptor.dupNode(STAR173);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR173_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2591);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2598);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new MultiplyExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)STAR173 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:803:4: ^( DIV left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV174=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr2613); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV174_tree = (CommonTree)adaptor.dupNode(DIV174);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV174_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2619);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2626);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new DivideExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)DIV174 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:808:4: ^( PERCENT left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT175=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr2641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT175_tree = (CommonTree)adaptor.dupNode(PERCENT175);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT175_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2647);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2654);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new ModExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)PERCENT175 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:813:4: const_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr2667);
                    const_expr176=const_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr176.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (const_expr176!=null?const_expr176.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:817:4: var_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr2678);
                    var_expr177=var_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr177.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (var_expr177!=null?var_expr177.expr:null); 
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:821:4: ^( NEG e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG178=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr2691); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG178_tree = (CommonTree)adaptor.dupNode(NEG178);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG178_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2697);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NegativeExpression( plan, (e!=null?e.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(e!=null?((CommonTree)e.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:826:4: ^( CAST_EXPR type_cast e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR179=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2712); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR179_tree = (CommonTree)adaptor.dupNode(CAST_EXPR179);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR179_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr2714);
                    type_cast180=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast180.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2720);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new CastExpression( plan, (e!=null?e.expr:null), (type_cast180!=null?type_cast180.fieldSchema:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(type_cast180!=null?((CommonTree)type_cast180.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:831:4: ^( EXPR_IN_PAREN e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN181=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr2736); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN181_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN181);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN181_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2742);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = (e!=null?e.expr:null);
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
        public LogicalFieldSchema fieldSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type_cast"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:837:1: type_cast returns [LogicalFieldSchema fieldSchema] : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final LogicalPlanGenerator.type_cast_return type_cast() throws RecognitionException {
        LogicalPlanGenerator.type_cast_return retval = new LogicalPlanGenerator.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.simple_type_return simple_type182 =null;

        LogicalPlanGenerator.map_type_return map_type183 =null;

        LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast184 =null;

        LogicalPlanGenerator.bag_type_cast_return bag_type_cast185 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:838:2: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt57=4;
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
                alt57=1;
                }
                break;
            case MAP_TYPE:
                {
                alt57=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt57=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt57=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }

            switch (alt57) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:838:4: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast2764);
                    simple_type182=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type182.getTree());


                    if ( state.backtracking==0 ) {
                            retval.fieldSchema = new LogicalFieldSchema( null, null, (simple_type182!=null?simple_type182.datatype:0) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:842:4: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast2774);
                    map_type183=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type183.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (map_type183!=null?map_type183.logicalSchema:null), DataType.MAP );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:846:4: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast2784);
                    tuple_type_cast184=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast184.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (tuple_type_cast184!=null?tuple_type_cast184.logicalSchema:null), DataType.TUPLE );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:850:4: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast2794);
                    bag_type_cast185=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast185.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (bag_type_cast185!=null?bag_type_cast185.logicalSchema:null), DataType.BAG );
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
    // $ANTLR end "type_cast"


    public static class tuple_type_cast_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type_cast"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:856:1: tuple_type_cast returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        LogicalPlanGenerator.tuple_type_cast_return retval = new LogicalPlanGenerator.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST186=null;
        LogicalPlanGenerator.type_cast_return type_cast187 =null;


        CommonTree TUPLE_TYPE_CAST186_tree=null;


            retval.logicalSchema = new LogicalSchema();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:860:2: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:860:4: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST186=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2819); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST186_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST186);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST186_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:860:23: ( type_cast )*
                loop58:
                do {
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==BOOLEAN||LA58_0==BYTEARRAY||LA58_0==CHARARRAY||LA58_0==DATETIME||LA58_0==DOUBLE||LA58_0==FLOAT||LA58_0==INT||LA58_0==LONG||LA58_0==BAG_TYPE_CAST||LA58_0==MAP_TYPE||LA58_0==TUPLE_TYPE_CAST) ) {
                        alt58=1;
                    }


                    switch (alt58) {
                	case 1 :
                	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:860:25: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2823);
                	    type_cast187=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast187.getTree());


                	    if ( state.backtracking==0 ) { retval.logicalSchema.addField( (type_cast187!=null?type_cast187.fieldSchema:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop58;
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
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:863:1: bag_type_cast returns [LogicalSchema logicalSchema] : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final LogicalPlanGenerator.bag_type_cast_return bag_type_cast() throws RecognitionException {
        LogicalPlanGenerator.bag_type_cast_return retval = new LogicalPlanGenerator.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST188=null;
        LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast189 =null;


        CommonTree BAG_TYPE_CAST188_tree=null;


            retval.logicalSchema = new LogicalSchema();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:867:2: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:867:4: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST188=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2850); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST188_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST188);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST188_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:867:21: ( tuple_type_cast )?
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==TUPLE_TYPE_CAST) ) {
                    alt59=1;
                }
                switch (alt59) {
                    case 1 :
                        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:867:21: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast2852);
                        tuple_type_cast189=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast189.getTree());


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
                   retval.logicalSchema.addField( new LogicalFieldSchema( null, (tuple_type_cast189!=null?tuple_type_cast189.logicalSchema:null), DataType.TUPLE ) );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:873:1: var_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : projectable_expr[$plan] ( dot_proj | pound_proj )* ;
    public final LogicalPlanGenerator.var_expr_return var_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.var_expr_return retval = new LogicalPlanGenerator.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.projectable_expr_return projectable_expr190 =null;

        LogicalPlanGenerator.dot_proj_return dot_proj191 =null;

        LogicalPlanGenerator.pound_proj_return pound_proj192 =null;




            List<Object> columns = null;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:878:2: ( projectable_expr[$plan] ( dot_proj | pound_proj )* )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:878:4: projectable_expr[$plan] ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr2879);
            projectable_expr190=projectable_expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr190.getTree());


            if ( state.backtracking==0 ) { retval.expr = (projectable_expr190!=null?projectable_expr190.expr:null); }

            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:879:4: ( dot_proj | pound_proj )*
            loop60:
            do {
                int alt60=3;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==PERIOD) ) {
                    alt60=1;
                }
                else if ( (LA60_0==POUND) ) {
                    alt60=2;
                }


                switch (alt60) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:879:6: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr2889);
            	    dot_proj191=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj191.getTree());


            	    if ( state.backtracking==0 ) {
            	             columns = (dot_proj191!=null?dot_proj191.cols:null);
            	             boolean processScalar = false;
            	             if( retval.expr instanceof ScalarExpression ) {
            	                 List<Operator> succs = plan.getSuccessors( retval.expr );
            	                 if( succs == null || succs.size() == 0 ) {
            	                     // We haven't process this scalar projection yet. Set the flag so as to process it next.
            	                     // This will handle a projection such as A.u.x, where we need to build ScalarExpression
            	                     // for A.u, while for x, we need to treat it as a normal dereference (on the output of
            	                     // the ScalarExpression.
            	                     processScalar = true;
            	                 }
            	             }
            	             
            	             if( processScalar ) {
            	                 // This is a scalar projection.
            	                 ScalarExpression scalarExpr = (ScalarExpression)retval.expr;
            	                 
            	                 if( (dot_proj191!=null?dot_proj191.cols:null).size() > 1 ) {
            	                     throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                 }
            	                 
            	                 Object val = (dot_proj191!=null?dot_proj191.cols:null).get( 0 );
            	                 int pos = -1;
            	                 LogicalRelationalOperator relOp = (LogicalRelationalOperator)scalarExpr.getImplicitReferencedOperator();
            	                 LogicalSchema schema = null;
            	                 try {
            	                     schema = relOp.getSchema();
            	                 } catch(FrontendException e) {
            	                     throw new PlanGenerationFailureException( input, loc, e );
            	                 }
            	                 if( val instanceof Integer ) {
            	                     pos = (Integer)val;
            	                     if( schema != null && pos >= schema.size() ) {
            	                         throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                     }
            	                 } else {
            	                     String colAlias = (String)val;
            	                     pos = schema.getFieldPosition( colAlias );
            	                     if( schema == null || pos == -1 ) {
            	                         throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                     }
            	                 }
            	                 
            	                 ConstantExpression constExpr = new ConstantExpression( plan, pos);
            	                 plan.connect( retval.expr, constExpr );
            	                 constExpr = new ConstantExpression( plan, "filename"); // place holder for file name.
            	                 plan.connect( retval.expr, constExpr );
            	             } else {
            	                 DereferenceExpression e = new DereferenceExpression( plan );
            	                 e.setRawColumns( (dot_proj191!=null?dot_proj191.cols:null) );
            	                 e.setLocation( new SourceLocation( (PigParserNode)(dot_proj191!=null?((CommonTree)dot_proj191.start):null) ) );
            	                 plan.connect( e, retval.expr );
            	                 retval.expr = e;
            	             }
            	         }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:936:6: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr2904);
            	    pound_proj192=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj192.getTree());


            	    if ( state.backtracking==0 ) {
            	             MapLookupExpression e = new MapLookupExpression( plan, (pound_proj192!=null?pound_proj192.key:null) );
            	             e.setLocation( new SourceLocation( (PigParserNode)(pound_proj192!=null?((CommonTree)pound_proj192.start):null) ) );
            	             plan.connect( e, retval.expr );
            	             retval.expr = e;
            	         }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            if ( state.backtracking==0 ) {
                  if( ( retval.expr instanceof ScalarExpression ) && columns == null ) {
                      throw new InvalidScalarProjectionException( input, loc, (ScalarExpression)retval.expr, " : A column needs to be projected from a relation for it to be used as a scalar" );
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
    // $ANTLR end "var_expr"


    public static class projectable_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "projectable_expr"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:951:1: projectable_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] );
    public final LogicalPlanGenerator.projectable_expr_return projectable_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.projectable_expr_return retval = new LogicalPlanGenerator.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.func_eval_return func_eval193 =null;

        LogicalPlanGenerator.col_ref_return col_ref194 =null;

        LogicalPlanGenerator.bin_expr_return bin_expr195 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:952:2: ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] )
            int alt61=3;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
                {
                alt61=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt61=2;
                }
                break;
            case BIN_EXPR:
                {
                alt61=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }

            switch (alt61) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:952:4: func_eval[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr2934);
                    func_eval193=func_eval(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval193.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (func_eval193!=null?func_eval193.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:956:4: col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr2945);
                    col_ref194=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref194.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (col_ref194!=null?col_ref194.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:960:4: bin_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr2956);
                    bin_expr195=bin_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr195.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (bin_expr195!=null?bin_expr195.expr:null);
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
    // $ANTLR end "projectable_expr"


    public static class dot_proj_return extends TreeRuleReturnScope {
        public List<Object> cols;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dot_proj"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:966:1: dot_proj returns [List<Object> cols] : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final LogicalPlanGenerator.dot_proj_return dot_proj() throws RecognitionException {
        LogicalPlanGenerator.dot_proj_return retval = new LogicalPlanGenerator.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD196=null;
        LogicalPlanGenerator.col_alias_or_index_return col_alias_or_index197 =null;


        CommonTree PERIOD196_tree=null;


            retval.cols = new ArrayList<Object>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:970:2: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:970:4: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD196=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj2982); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD196_tree = (CommonTree)adaptor.dupNode(PERIOD196);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD196_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:970:14: ( col_alias_or_index )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==CUBE||LA62_0==DOLLARVAR||LA62_0==GROUP||LA62_0==IDENTIFIER) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:970:16: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2986);
            	    col_alias_or_index197=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index197.getTree());


            	    if ( state.backtracking==0 ) { retval.cols.add( (col_alias_or_index197!=null?col_alias_or_index197.col:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt62 >= 1 ) break loop62;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
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
        public Object col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:973:1: col_alias_or_index returns [Object col] : ( col_alias | col_index );
    public final LogicalPlanGenerator.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        LogicalPlanGenerator.col_alias_or_index_return retval = new LogicalPlanGenerator.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.col_alias_return col_alias198 =null;

        LogicalPlanGenerator.col_index_return col_index199 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:974:2: ( col_alias | col_index )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==CUBE||LA63_0==GROUP||LA63_0==IDENTIFIER) ) {
                alt63=1;
            }
            else if ( (LA63_0==DOLLARVAR) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;

            }
            switch (alt63) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:974:4: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index3006);
                    col_alias198=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias198.getTree());


                    if ( state.backtracking==0 ) { retval.col = (col_alias198!=null?col_alias198.col:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:974:43: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index3012);
                    col_index199=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index199.getTree());


                    if ( state.backtracking==0 ) { retval.col = (col_index199!=null?col_index199.col:null); }

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
        public Object col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:977:1: col_alias returns [Object col] : ( GROUP | CUBE | IDENTIFIER );
    public final LogicalPlanGenerator.col_alias_return col_alias() throws RecognitionException {
        LogicalPlanGenerator.col_alias_return retval = new LogicalPlanGenerator.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP200=null;
        CommonTree CUBE201=null;
        CommonTree IDENTIFIER202=null;

        CommonTree GROUP200_tree=null;
        CommonTree CUBE201_tree=null;
        CommonTree IDENTIFIER202_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:978:2: ( GROUP | CUBE | IDENTIFIER )
            int alt64=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt64=1;
                }
                break;
            case CUBE:
                {
                alt64=2;
                }
                break;
            case IDENTIFIER:
                {
                alt64=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }

            switch (alt64) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:978:4: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP200=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_col_alias3027); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP200_tree = (CommonTree)adaptor.dupNode(GROUP200);


                    adaptor.addChild(root_0, GROUP200_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (GROUP200!=null?GROUP200.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:979:4: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE201=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_col_alias3034); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE201_tree = (CommonTree)adaptor.dupNode(CUBE201);


                    adaptor.addChild(root_0, CUBE201_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (CUBE201!=null?CUBE201.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:980:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER202=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_col_alias3041); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER202_tree = (CommonTree)adaptor.dupNode(IDENTIFIER202);


                    adaptor.addChild(root_0, IDENTIFIER202_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (IDENTIFIER202!=null?IDENTIFIER202.getText():null); }

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
    // $ANTLR end "col_alias"


    public static class col_index_return extends TreeRuleReturnScope {
        public Integer col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:983:1: col_index returns [Integer col] : DOLLARVAR ;
    public final LogicalPlanGenerator.col_index_return col_index() throws RecognitionException {
        LogicalPlanGenerator.col_index_return retval = new LogicalPlanGenerator.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR203=null;

        CommonTree DOLLARVAR203_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:984:2: ( DOLLARVAR )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:984:4: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR203=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index3056); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR203_tree = (CommonTree)adaptor.dupNode(DOLLARVAR203);


            adaptor.addChild(root_0, DOLLARVAR203_tree);
            }


            if ( state.backtracking==0 ) { retval.col = builder.undollar( (DOLLARVAR203!=null?DOLLARVAR203.getText():null) ); }

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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:988:1: col_range[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) ;
    public final LogicalPlanGenerator.col_range_return col_range(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.col_range_return retval = new LogicalPlanGenerator.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE204=null;
        CommonTree DOUBLE_PERIOD205=null;
        LogicalPlanGenerator.col_ref_return startExpr =null;

        LogicalPlanGenerator.col_ref_return endExpr =null;


        CommonTree COL_RANGE204_tree=null;
        CommonTree DOUBLE_PERIOD205_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:989:2: ( ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:989:5: ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE204=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range3075); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE204_tree = (CommonTree)adaptor.dupNode(COL_RANGE204);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE204_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:989:17: (startExpr= col_ref[$plan] )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==CUBE||LA65_0==DOLLARVAR||LA65_0==GROUP||LA65_0==IDENTIFIER) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:989:18: startExpr= col_ref[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range3082);
                    startExpr=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, startExpr.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD205=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range3087); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD205_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD205);


            adaptor.addChild(root_1, DOUBLE_PERIOD205_tree);
            }


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:989:61: (endExpr= col_ref[$plan] )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==CUBE||LA66_0==DOLLARVAR||LA66_0==GROUP||LA66_0==IDENTIFIER) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:989:62: endExpr= col_ref[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range3094);
                    endExpr=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, endExpr.getTree());


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
                    SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                    retval.expr = builder.buildRangeProjectExpr(
                                loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                ((statement_scope)statement_stack.peek()).inputIndex, 
                                (startExpr!=null?startExpr.expr:null), 
                                (endExpr!=null?endExpr.expr:null)
                            );
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
        public String key;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pound_proj"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1001:1: pound_proj returns [String key] : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final LogicalPlanGenerator.pound_proj_return pound_proj() throws RecognitionException {
        LogicalPlanGenerator.pound_proj_return retval = new LogicalPlanGenerator.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND206=null;
        CommonTree QUOTEDSTRING207=null;
        CommonTree NULL208=null;

        CommonTree POUND206_tree=null;
        CommonTree QUOTEDSTRING207_tree=null;
        CommonTree NULL208_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1002:2: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1002:4: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND206=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj3122); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND206_tree = (CommonTree)adaptor.dupNode(POUND206);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND206_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1002:13: ( QUOTEDSTRING | NULL )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==QUOTEDSTRING) ) {
                alt67=1;
            }
            else if ( (LA67_0==NULL) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }
            switch (alt67) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1002:15: QUOTEDSTRING
                    {
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING207=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_pound_proj3126); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING207_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING207);


                    adaptor.addChild(root_1, QUOTEDSTRING207_tree);
                    }


                    if ( state.backtracking==0 ) { retval.key = builder.unquote( (QUOTEDSTRING207!=null?QUOTEDSTRING207.getText():null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1002:80: NULL
                    {
                    _last = (CommonTree)input.LT(1);
                    NULL208=(CommonTree)match(input,NULL,FOLLOW_NULL_in_pound_proj3132); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL208_tree = (CommonTree)adaptor.dupNode(NULL208);


                    adaptor.addChild(root_1, NULL208_tree);
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
    // $ANTLR end "pound_proj"


    public static class bin_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bin_expr"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1005:1: bin_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) ;
    public final LogicalPlanGenerator.bin_expr_return bin_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.bin_expr_return retval = new LogicalPlanGenerator.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR209=null;
        LogicalPlanGenerator.expr_return e1 =null;

        LogicalPlanGenerator.expr_return e2 =null;

        LogicalPlanGenerator.cond_return cond210 =null;


        CommonTree BIN_EXPR209_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1006:2: ( ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1006:4: ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR209=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr3152); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR209_tree = (CommonTree)adaptor.dupNode(BIN_EXPR209);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR209_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr3154);
            cond210=cond(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond210.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr3161);
            e1=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e1.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr3168);
            e2=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e2.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.expr = new BinCondExpression( plan, (cond210!=null?cond210.expr:null), (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                   retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limit_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1013:1: limit_clause returns [String alias] : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.limit_clause_return limit_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.limit_clause_return retval = new LogicalPlanGenerator.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT211=null;
        CommonTree INTEGER213=null;
        CommonTree LONGINTEGER214=null;
        LogicalPlanGenerator.rel_return rel212 =null;

        LogicalPlanGenerator.expr_return expr215 =null;


        CommonTree LIMIT211_tree=null;
        CommonTree INTEGER213_tree=null;
        CommonTree LONGINTEGER214_tree=null;

         
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createLimitOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1019:2: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1019:5: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT211=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause3202); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT211_tree = (CommonTree)adaptor.dupNode(LIMIT211);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT211_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause3204);
            rel212=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel212.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1019:18: ( INTEGER | LONGINTEGER | expr[exprPlan] )
            int alt68=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA68_1 = input.LA(2);

                if ( (synpred128_LogicalPlanGenerator()) ) {
                    alt68=1;
                }
                else if ( (true) ) {
                    alt68=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA68_2 = input.LA(2);

                if ( (synpred129_LogicalPlanGenerator()) ) {
                    alt68=2;
                }
                else if ( (true) ) {
                    alt68=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 2, input);

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
                alt68=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;

            }

            switch (alt68) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1019:20: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER213=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause3208); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER213_tree = (CommonTree)adaptor.dupNode(INTEGER213);


                    adaptor.addChild(root_1, INTEGER213_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT211 ), 
                             ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, Long.valueOf( (INTEGER213!=null?INTEGER213.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1024:4: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER214=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause3218); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER214_tree = (CommonTree)adaptor.dupNode(LONGINTEGER214);


                    adaptor.addChild(root_1, LONGINTEGER214_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT211 ),
                             ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, builder.parseLong( (LONGINTEGER214!=null?LONGINTEGER214.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1029:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause3228);
                    expr215=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr215.getTree());


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT211 ),
                               (LOLimit)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, exprPlan);
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "limit_clause"


    public static class sample_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sample_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1037:1: sample_clause returns [String alias] : ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.sample_clause_return sample_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.sample_clause_return retval = new LogicalPlanGenerator.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE216=null;
        CommonTree DOUBLENUMBER218=null;
        LogicalPlanGenerator.rel_return rel217 =null;

        LogicalPlanGenerator.expr_return expr219 =null;


        CommonTree SAMPLE216_tree=null;
        CommonTree DOUBLENUMBER218_tree=null;

         
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSampleOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1043:2: ( ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1043:4: ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE216=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause3264); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE216_tree = (CommonTree)adaptor.dupNode(SAMPLE216);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE216_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause3266);
            rel217=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel217.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1043:18: ( DOUBLENUMBER | expr[exprPlan] )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==DOUBLENUMBER) ) {
                int LA69_1 = input.LA(2);

                if ( (synpred130_LogicalPlanGenerator()) ) {
                    alt69=1;
                }
                else if ( (true) ) {
                    alt69=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA69_0==CUBE||LA69_0==DIV||LA69_0==DOLLARVAR||LA69_0==FALSE||LA69_0==FLOATNUMBER||LA69_0==GROUP||LA69_0==INTEGER||LA69_0==LONGINTEGER||LA69_0==MINUS||LA69_0==PERCENT||LA69_0==PLUS||LA69_0==QUOTEDSTRING||LA69_0==STAR||LA69_0==TRUE||(LA69_0 >= BAG_VAL && LA69_0 <= BIN_EXPR)||LA69_0==CAST_EXPR||LA69_0==EXPR_IN_PAREN||LA69_0==FUNC_EVAL||LA69_0==IDENTIFIER||(LA69_0 >= MAP_VAL && LA69_0 <= NEG)||LA69_0==NULL||LA69_0==TUPLE_VAL) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;

            }
            switch (alt69) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1043:20: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER218=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause3270); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER218_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER218);


                    adaptor.addChild(root_1, DOUBLENUMBER218_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildSampleOp( new SourceLocation( (PigParserNode)SAMPLE216 ), ((statement_scope)statement_stack.peek()).alias,
                               ((statement_scope)statement_stack.peek()).inputAlias, Double.valueOf( (DOUBLENUMBER218!=null?DOUBLENUMBER218.getText():null) ),
                               new SourceLocation( (PigParserNode)DOUBLENUMBER218 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1049:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause3280);
                    expr219=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr219.getTree());


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildSampleOp( new SourceLocation( (PigParserNode)SAMPLE216 ),
                               (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, exprPlan, (expr219!=null?expr219.expr:null));
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "sample_clause"


    protected static class rank_clause_scope {
        LORank rankOp;
    }
    protected Stack rank_clause_stack = new Stack();


    public static class rank_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1057:1: rank_clause returns [String alias] : ^( RANK rel ( rank_by_statement )? ) ;
    public final LogicalPlanGenerator.rank_clause_return rank_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        rank_clause_stack.push(new rank_clause_scope());
        LogicalPlanGenerator.rank_clause_return retval = new LogicalPlanGenerator.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK220=null;
        LogicalPlanGenerator.rel_return rel221 =null;

        LogicalPlanGenerator.rank_by_statement_return rank_by_statement222 =null;


        CommonTree RANK220_tree=null;


        	((GScope_scope)GScope_stack.peek()).currentOp = builder.createRankOp();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1067:2: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1067:4: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK220=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause3326); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK220_tree = (CommonTree)adaptor.dupNode(RANK220);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK220_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause3328);
            rel221=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel221.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1067:16: ( rank_by_statement )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==BY) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1067:16: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause3330);
                    rank_by_statement222=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement222.getTree());


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
            	SourceLocation loc = new SourceLocation( (PigParserNode) ((CommonTree)retval.start) );

            	List<LogicalExpressionPlan> tempPlans = (rank_by_statement222!=null?rank_by_statement222.plans:null);
            	List<Boolean> tempAscFlags = (rank_by_statement222!=null?rank_by_statement222.ascFlags:null);

            	if(tempPlans == null && tempAscFlags == null) {
            		tempPlans = new ArrayList<LogicalExpressionPlan>();
            		tempAscFlags = new ArrayList<Boolean>();

            		((LORank)((GScope_scope)GScope_stack.peek()).currentOp).setIsRowNumber( true );
            	}

            	((LORank)((GScope_scope)GScope_stack.peek()).currentOp).setIsDenseRank( (rank_by_statement222!=null?rank_by_statement222.isDenseRank:null) != null?(rank_by_statement222!=null?rank_by_statement222.isDenseRank:null):false );

            	retval.alias = builder.buildRankOp( loc, (LORank)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, tempPlans, tempAscFlags );
             }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            rank_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "rank_clause"


    public static class rank_by_statement_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        public Boolean isDenseRank;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_statement"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1087:1: rank_by_statement returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags, Boolean isDenseRank] : ^( BY rank_by_clause ( DENSE )? ) ;
    public final LogicalPlanGenerator.rank_by_statement_return rank_by_statement() throws RecognitionException {
        LogicalPlanGenerator.rank_by_statement_return retval = new LogicalPlanGenerator.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY223=null;
        CommonTree DENSE225=null;
        LogicalPlanGenerator.rank_by_clause_return rank_by_clause224 =null;


        CommonTree BY223_tree=null;
        CommonTree DENSE225_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();
            retval.isDenseRank = false;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1093:2: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1093:4: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY223=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement3356); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY223_tree = (CommonTree)adaptor.dupNode(BY223);


            root_1 = (CommonTree)adaptor.becomeRoot(BY223_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement3358);
            rank_by_clause224=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause224.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1093:25: ( DENSE )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==DENSE) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1093:27: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE225=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement3362); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE225_tree = (CommonTree)adaptor.dupNode(DENSE225);


                    adaptor.addChild(root_1, DENSE225_tree);
                    }


                    if ( state.backtracking==0 ) { retval.isDenseRank =  true; }

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
            	retval.plans = (rank_by_clause224!=null?rank_by_clause224.plans:null);
            	retval.ascFlags = (rank_by_clause224!=null?rank_by_clause224.ascFlags:null);
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
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1100:1: rank_by_clause returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags] : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final LogicalPlanGenerator.rank_by_clause_return rank_by_clause() throws RecognitionException {
        LogicalPlanGenerator.rank_by_clause_return retval = new LogicalPlanGenerator.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR226=null;
        CommonTree ASC227=null;
        CommonTree DESC228=null;
        LogicalPlanGenerator.rank_col_return rank_col229 =null;


        CommonTree STAR226_tree=null;
        CommonTree ASC227_tree=null;
        CommonTree DESC228_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1105:2: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==STAR) ) {
                alt74=1;
            }
            else if ( (LA74_0==CUBE||LA74_0==DOLLARVAR||LA74_0==GROUP||LA74_0==COL_RANGE||LA74_0==IDENTIFIER) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;

            }
            switch (alt74) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1105:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR226=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause3391); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR226_tree = (CommonTree)adaptor.dupNode(STAR226);


                    adaptor.addChild(root_0, STAR226_tree);
                    }


                    if ( state.backtracking==0 ) {
                    		LogicalExpressionPlan plan = new LogicalExpressionPlan();
                    		builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR226 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                    		retval.plans.add( plan );
                       }

                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1110:4: ( ASC | DESC )?
                    int alt72=3;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==ASC) ) {
                        alt72=1;
                    }
                    else if ( (LA72_0==DESC) ) {
                        alt72=2;
                    }
                    switch (alt72) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1110:6: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC227=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_by_clause3400); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC227_tree = (CommonTree)adaptor.dupNode(ASC227);


                            adaptor.addChild(root_0, ASC227_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1110:39: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC228=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_by_clause3406); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC228_tree = (CommonTree)adaptor.dupNode(DESC228);


                            adaptor.addChild(root_0, DESC228_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1111:4: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1111:4: ( rank_col )+
                    int cnt73=0;
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==CUBE||LA73_0==DOLLARVAR||LA73_0==GROUP||LA73_0==COL_RANGE||LA73_0==IDENTIFIER) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1111:6: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause3418);
                    	    rank_col229=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col229.getTree());


                    	    if ( state.backtracking==0 ) {
                    	           retval.plans.add( (rank_col229!=null?rank_col229.plan:null) );
                    	           retval.ascFlags.add( (rank_col229!=null?rank_col229.ascFlag:null) );
                    	       }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt73 >= 1 ) break loop73;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(73, input);
                                throw eee;
                        }
                        cnt73++;
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
        public LogicalExpressionPlan plan;
        public Boolean ascFlag;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_col"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1118:1: rank_col returns [LogicalExpressionPlan plan, Boolean ascFlag] : ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? );
    public final LogicalPlanGenerator.rank_col_return rank_col() throws RecognitionException {
        LogicalPlanGenerator.rank_col_return retval = new LogicalPlanGenerator.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC231=null;
        CommonTree DESC232=null;
        CommonTree ASC234=null;
        CommonTree DESC235=null;
        LogicalPlanGenerator.col_range_return col_range230 =null;

        LogicalPlanGenerator.col_ref_return col_ref233 =null;


        CommonTree ASC231_tree=null;
        CommonTree DESC232_tree=null;
        CommonTree ASC234_tree=null;
        CommonTree DESC235_tree=null;


            retval.plan = new LogicalExpressionPlan();
            retval.ascFlag = true;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1123:2: ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==COL_RANGE) ) {
                alt77=1;
            }
            else if ( (LA77_0==CUBE||LA77_0==DOLLARVAR||LA77_0==GROUP||LA77_0==IDENTIFIER) ) {
                alt77=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;

            }
            switch (alt77) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1123:4: col_range[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col3444);
                    col_range230=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range230.getTree());


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1123:21: ( ASC | DESC )?
                    int alt75=3;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==ASC) ) {
                        alt75=1;
                    }
                    else if ( (LA75_0==DESC) ) {
                        alt75=2;
                    }
                    switch (alt75) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1123:22: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC231=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col3448); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC231_tree = (CommonTree)adaptor.dupNode(ASC231);


                            adaptor.addChild(root_0, ASC231_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1123:28: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC232=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col3452); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC232_tree = (CommonTree)adaptor.dupNode(DESC232);


                            adaptor.addChild(root_0, DESC232_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1124:4: col_ref[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col3462);
                    col_ref233=col_ref(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref233.getTree());


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1124:19: ( ASC | DESC )?
                    int alt76=3;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==ASC) ) {
                        alt76=1;
                    }
                    else if ( (LA76_0==DESC) ) {
                        alt76=2;
                    }
                    switch (alt76) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1124:21: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC234=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col3467); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC234_tree = (CommonTree)adaptor.dupNode(ASC234);


                            adaptor.addChild(root_0, ASC234_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1124:27: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC235=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col3471); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC235_tree = (CommonTree)adaptor.dupNode(DESC235);


                            adaptor.addChild(root_0, DESC235_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1127:1: order_clause returns [String alias] : ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
    public final LogicalPlanGenerator.order_clause_return order_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.order_clause_return retval = new LogicalPlanGenerator.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER236=null;
        LogicalPlanGenerator.rel_return rel237 =null;

        LogicalPlanGenerator.order_by_clause_return order_by_clause238 =null;

        LogicalPlanGenerator.func_clause_return func_clause239 =null;


        CommonTree ORDER236_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSortOp();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1132:2: ( ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1132:4: ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER236=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause3501); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER236_tree = (CommonTree)adaptor.dupNode(ORDER236);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER236_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause3503);
            rel237=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel237.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause3505);
            order_by_clause238=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause238.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1132:33: ( func_clause[FunctionType.COMPARISONFUNC] )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==FUNC||LA78_0==FUNC_REF) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1132:33: func_clause[FunctionType.COMPARISONFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause3507);
                    func_clause239=func_clause(FunctionType.COMPARISONFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause239.getTree());


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
                   SourceLocation loc = new SourceLocation( (PigParserNode)ORDER236 );
                   retval.alias = builder.buildSortOp( loc, (LOSort)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                       ((statement_scope)statement_stack.peek()).inputAlias, (order_by_clause238!=null?order_by_clause238.plans:null), 
                       (order_by_clause238!=null?order_by_clause238.ascFlags:null), (func_clause239!=null?func_clause239.funcSpec:null) );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "order_clause"


    public static class order_by_clause_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_by_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1141:1: order_by_clause returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags] : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final LogicalPlanGenerator.order_by_clause_return order_by_clause() throws RecognitionException {
        LogicalPlanGenerator.order_by_clause_return retval = new LogicalPlanGenerator.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR240=null;
        CommonTree ASC241=null;
        CommonTree DESC242=null;
        LogicalPlanGenerator.order_col_return order_col243 =null;


        CommonTree STAR240_tree=null;
        CommonTree ASC241_tree=null;
        CommonTree DESC242_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1146:2: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==STAR) ) {
                alt81=1;
            }
            else if ( (LA81_0==CUBE||LA81_0==DOLLARVAR||LA81_0==GROUP||LA81_0==COL_RANGE||LA81_0==IDENTIFIER) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;

            }
            switch (alt81) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1146:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR240=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause3534); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR240_tree = (CommonTree)adaptor.dupNode(STAR240);


                    adaptor.addChild(root_0, STAR240_tree);
                    }


                    if ( state.backtracking==0 ) {
                           LogicalExpressionPlan plan = new LogicalExpressionPlan();
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR240 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                           retval.plans.add( plan );
                       }

                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1152:4: ( ASC | DESC )?
                    int alt79=3;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==ASC) ) {
                        alt79=1;
                    }
                    else if ( (LA79_0==DESC) ) {
                        alt79=2;
                    }
                    switch (alt79) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1152:6: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC241=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_by_clause3543); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC241_tree = (CommonTree)adaptor.dupNode(ASC241);


                            adaptor.addChild(root_0, ASC241_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1152:39: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC242=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_by_clause3549); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC242_tree = (CommonTree)adaptor.dupNode(DESC242);


                            adaptor.addChild(root_0, DESC242_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1153:4: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1153:4: ( order_col )+
                    int cnt80=0;
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==CUBE||LA80_0==DOLLARVAR||LA80_0==GROUP||LA80_0==COL_RANGE||LA80_0==IDENTIFIER) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1153:6: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause3561);
                    	    order_col243=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col243.getTree());


                    	    if ( state.backtracking==0 ) {
                    	           retval.plans.add( (order_col243!=null?order_col243.plan:null) );
                    	           retval.ascFlags.add( (order_col243!=null?order_col243.ascFlag:null) );
                    	       }

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
    // $ANTLR end "order_by_clause"


    public static class order_col_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        public Boolean ascFlag;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_col"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1160:1: order_col returns [LogicalExpressionPlan plan, Boolean ascFlag] : ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? );
    public final LogicalPlanGenerator.order_col_return order_col() throws RecognitionException {
        LogicalPlanGenerator.order_col_return retval = new LogicalPlanGenerator.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC245=null;
        CommonTree DESC246=null;
        CommonTree ASC248=null;
        CommonTree DESC249=null;
        LogicalPlanGenerator.col_range_return col_range244 =null;

        LogicalPlanGenerator.col_ref_return col_ref247 =null;


        CommonTree ASC245_tree=null;
        CommonTree DESC246_tree=null;
        CommonTree ASC248_tree=null;
        CommonTree DESC249_tree=null;

         
            retval.plan = new LogicalExpressionPlan();
            retval.ascFlag = true;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1165:2: ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==COL_RANGE) ) {
                alt84=1;
            }
            else if ( (LA84_0==CUBE||LA84_0==DOLLARVAR||LA84_0==GROUP||LA84_0==IDENTIFIER) ) {
                alt84=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;

            }
            switch (alt84) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1165:4: col_range[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col3587);
                    col_range244=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range244.getTree());


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1165:21: ( ASC | DESC )?
                    int alt82=3;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==ASC) ) {
                        alt82=1;
                    }
                    else if ( (LA82_0==DESC) ) {
                        alt82=2;
                    }
                    switch (alt82) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1165:22: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC245=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col3591); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC245_tree = (CommonTree)adaptor.dupNode(ASC245);


                            adaptor.addChild(root_0, ASC245_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1165:28: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC246=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col3595); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC246_tree = (CommonTree)adaptor.dupNode(DESC246);


                            adaptor.addChild(root_0, DESC246_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1166:4: col_ref[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col3605);
                    col_ref247=col_ref(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref247.getTree());


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1166:19: ( ASC | DESC )?
                    int alt83=3;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==ASC) ) {
                        alt83=1;
                    }
                    else if ( (LA83_0==DESC) ) {
                        alt83=2;
                    }
                    switch (alt83) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1166:21: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC248=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col3610); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC248_tree = (CommonTree)adaptor.dupNode(ASC248);


                            adaptor.addChild(root_0, ASC248_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1166:27: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC249=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col3614); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC249_tree = (CommonTree)adaptor.dupNode(DESC249);


                            adaptor.addChild(root_0, DESC249_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "distinct_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1169:1: distinct_clause returns [String alias] : ^( DISTINCT rel ( partition_clause )? ) ;
    public final LogicalPlanGenerator.distinct_clause_return distinct_clause() throws RecognitionException {
        LogicalPlanGenerator.distinct_clause_return retval = new LogicalPlanGenerator.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT250=null;
        LogicalPlanGenerator.rel_return rel251 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause252 =null;


        CommonTree DISTINCT250_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1170:2: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1170:4: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT250=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause3642); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT250_tree = (CommonTree)adaptor.dupNode(DISTINCT250);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT250_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause3644);
            rel251=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel251.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1170:20: ( partition_clause )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==PARTITION) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1170:20: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause3646);
                    partition_clause252=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause252.getTree());


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
                   retval.alias = builder.buildDistinctOp( new SourceLocation( (PigParserNode)DISTINCT250 ), ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (partition_clause252!=null?partition_clause252.partitioner:null) );
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
        public String partitioner;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partition_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1177:1: partition_clause returns [String partitioner] : ^( PARTITION func_name ) ;
    public final LogicalPlanGenerator.partition_clause_return partition_clause() throws RecognitionException {
        LogicalPlanGenerator.partition_clause_return retval = new LogicalPlanGenerator.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION253=null;
        LogicalPlanGenerator.func_name_return func_name254 =null;


        CommonTree PARTITION253_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1178:2: ( ^( PARTITION func_name ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1178:4: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION253=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause3669); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION253_tree = (CommonTree)adaptor.dupNode(PARTITION253);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION253_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause3671);
            func_name254=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name254.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.partitioner = (func_name254!=null?func_name254.funcName:null);
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cross_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1184:1: cross_clause returns [String alias] : ^( CROSS rel_list ( partition_clause )? ) ;
    public final LogicalPlanGenerator.cross_clause_return cross_clause() throws RecognitionException {
        LogicalPlanGenerator.cross_clause_return retval = new LogicalPlanGenerator.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS255=null;
        LogicalPlanGenerator.rel_list_return rel_list256 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause257 =null;


        CommonTree CROSS255_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1185:2: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1185:4: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS255=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause3693); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS255_tree = (CommonTree)adaptor.dupNode(CROSS255);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS255_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause3695);
            rel_list256=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list256.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1185:22: ( partition_clause )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==PARTITION) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1185:22: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause3697);
                    partition_clause257=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause257.getTree());


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
                   retval.alias = builder.buildCrossOp( new SourceLocation( (PigParserNode)CROSS255 ), ((statement_scope)statement_stack.peek()).alias,
                      (rel_list256!=null?rel_list256.aliasList:null), (partition_clause257!=null?partition_clause257.partitioner:null) );
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
        public List<String> aliasList;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_list"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1192:1: rel_list returns [List<String> aliasList] : ( rel )+ ;
    public final LogicalPlanGenerator.rel_list_return rel_list() throws RecognitionException {
        LogicalPlanGenerator.rel_list_return retval = new LogicalPlanGenerator.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.rel_return rel258 =null;



         retval.aliasList = new ArrayList<String>(); 
        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1194:2: ( ( rel )+ )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1194:4: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1194:4: ( rel )+
            int cnt87=0;
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==COGROUP||(LA87_0 >= CROSS && LA87_0 <= CUBE)||LA87_0==DEFINE||LA87_0==DISTINCT||LA87_0==FILTER||LA87_0==FOREACH||LA87_0==GROUP||LA87_0==JOIN||(LA87_0 >= LIMIT && LA87_0 <= LOAD)||LA87_0==MAPREDUCE||LA87_0==ORDER||LA87_0==RANK||LA87_0==SAMPLE||(LA87_0 >= STORE && LA87_0 <= STREAM)||LA87_0==UNION||LA87_0==IDENTIFIER) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1194:6: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list3725);
            	    rel258=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel258.getTree());


            	    if ( state.backtracking==0 ) { retval.aliasList.add( ((statement_scope)statement_stack.peek()).inputAlias ); }

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


    protected static class join_clause_scope {
        MultiMap<Integer, LogicalExpressionPlan> joinPlans;
        int inputIndex;
        List<String> inputAliases;
        List<Boolean> innerFlags;
    }
    protected Stack join_clause_stack = new Stack();


    public static class join_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1197:1: join_clause returns [String alias] : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final LogicalPlanGenerator.join_clause_return join_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        join_clause_stack.push(new join_clause_scope());
        LogicalPlanGenerator.join_clause_return retval = new LogicalPlanGenerator.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN259=null;
        LogicalPlanGenerator.join_sub_clause_return join_sub_clause260 =null;

        LogicalPlanGenerator.join_type_return join_type261 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause262 =null;


        CommonTree JOIN259_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createJoinOp();
            ((join_clause_scope)join_clause_stack.peek()).joinPlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((join_clause_scope)join_clause_stack.peek()).inputAliases = new ArrayList<String>();
            ((join_clause_scope)join_clause_stack.peek()).innerFlags = new ArrayList<Boolean>();
            int oldStatementIndex = ((statement_scope)statement_stack.peek()).inputIndex;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:2: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:4: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN259=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause3764); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN259_tree = (CommonTree)adaptor.dupNode(JOIN259);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN259_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause3766);
            join_sub_clause260=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause260.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:28: ( join_type )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==QUOTEDSTRING) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:28: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause3768);
                    join_type261=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type261.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:39: ( partition_clause )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==PARTITION) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:39: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause3771);
                    partition_clause262=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause262.getTree());


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
                   SourceLocation loc = new SourceLocation( (PigParserNode)JOIN259 );
                   retval.alias = builder.buildJoinOp( loc, (LOJoin)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                      ((join_clause_scope)join_clause_stack.peek()).inputAliases, ((join_clause_scope)join_clause_stack.peek()).joinPlans,
                      (join_type261!=null?join_type261.type:null), ((join_clause_scope)join_clause_stack.peek()).innerFlags, (partition_clause262!=null?partition_clause262.partitioner:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
               ((statement_scope)statement_stack.peek()).inputIndex =oldStatementIndex;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            join_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        public JOINTYPE type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1224:1: join_type returns [JOINTYPE type] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.join_type_return join_type() throws RecognitionException {
        LogicalPlanGenerator.join_type_return retval = new LogicalPlanGenerator.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING263=null;

        CommonTree QUOTEDSTRING263_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1225:2: ( QUOTEDSTRING )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1225:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING263=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type3792); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING263_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING263);


            adaptor.addChild(root_0, QUOTEDSTRING263_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.type = builder.parseJoinType( (QUOTEDSTRING263!=null?QUOTEDSTRING263.getText():null), new SourceLocation( (PigParserNode)QUOTEDSTRING263 ) );
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1231:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final LogicalPlanGenerator.join_sub_clause_return join_sub_clause() throws RecognitionException {
        LogicalPlanGenerator.join_sub_clause_return retval = new LogicalPlanGenerator.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LEFT265=null;
        CommonTree RIGHT266=null;
        CommonTree FULL267=null;
        CommonTree OUTER268=null;
        LogicalPlanGenerator.join_item_return join_item264 =null;

        LogicalPlanGenerator.join_item_return join_item269 =null;

        LogicalPlanGenerator.join_item_return join_item270 =null;


        CommonTree LEFT265_tree=null;
        CommonTree RIGHT266_tree=null;
        CommonTree FULL267_tree=null;
        CommonTree OUTER268_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1232:2: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==JOIN_ITEM) ) {
                int LA93_1 = input.LA(2);

                if ( (synpred160_LogicalPlanGenerator()) ) {
                    alt93=1;
                }
                else if ( (true) ) {
                    alt93=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 93, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;

            }
            switch (alt93) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1232:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause3807);
                    join_item264=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item264.getTree());


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1232:14: ( LEFT | RIGHT | FULL )
                    int alt90=3;
                    switch ( input.LA(1) ) {
                    case LEFT:
                        {
                        alt90=1;
                        }
                        break;
                    case RIGHT:
                        {
                        alt90=2;
                        }
                        break;
                    case FULL:
                        {
                        alt90=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 90, 0, input);

                        throw nvae;

                    }

                    switch (alt90) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1232:16: LEFT
                            {
                            _last = (CommonTree)input.LT(1);
                            LEFT265=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_join_sub_clause3811); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LEFT265_tree = (CommonTree)adaptor.dupNode(LEFT265);


                            adaptor.addChild(root_0, LEFT265_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( true ); 
                                                  ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1234:16: RIGHT
                            {
                            _last = (CommonTree)input.LT(1);
                            RIGHT266=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_join_sub_clause3831); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RIGHT266_tree = (CommonTree)adaptor.dupNode(RIGHT266);


                            adaptor.addChild(root_0, RIGHT266_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); 
                                                   ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 3 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1236:16: FULL
                            {
                            _last = (CommonTree)input.LT(1);
                            FULL267=(CommonTree)match(input,FULL,FOLLOW_FULL_in_join_sub_clause3850); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            FULL267_tree = (CommonTree)adaptor.dupNode(FULL267);


                            adaptor.addChild(root_0, FULL267_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); 
                                                  ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1237:66: ( OUTER )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==OUTER) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1237:66: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER268=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause3856); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER268_tree = (CommonTree)adaptor.dupNode(OUTER268);


                            adaptor.addChild(root_0, OUTER268_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause3859);
                    join_item269=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item269.getTree());


                    if ( state.backtracking==0 ) {
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1240:4: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1240:4: ( join_item )+
                    int cnt92=0;
                    loop92:
                    do {
                        int alt92=2;
                        int LA92_0 = input.LA(1);

                        if ( (LA92_0==JOIN_ITEM) ) {
                            alt92=1;
                        }


                        switch (alt92) {
                    	case 1 :
                    	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1240:4: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause3869);
                    	    join_item270=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item270.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt92 >= 1 ) break loop92;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(92, input);
                                throw eee;
                        }
                        cnt92++;
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1243:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final LogicalPlanGenerator.join_item_return join_item() throws RecognitionException {
        LogicalPlanGenerator.join_item_return retval = new LogicalPlanGenerator.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM271=null;
        LogicalPlanGenerator.rel_return rel272 =null;

        LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause273 =null;


        CommonTree JOIN_ITEM271_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1244:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1244:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM271=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item3882); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM271_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM271);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM271_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item3884);
            rel272=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel272.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item3886);
            join_group_by_clause273=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause273.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   ((join_clause_scope)join_clause_stack.peek()).inputAliases.add( ((statement_scope)statement_stack.peek()).inputAlias );
                   ((join_clause_scope)join_clause_stack.peek()).joinPlans.put( ((join_clause_scope)join_clause_stack.peek()).inputIndex, (join_group_by_clause273!=null?join_group_by_clause273.plans:null) );
                   ((join_clause_scope)join_clause_stack.peek()).inputIndex++;
                   ((statement_scope)statement_stack.peek()).inputIndex++;
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
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1253:1: join_group_by_clause returns [List<LogicalExpressionPlan> plans] : ^( BY ( join_group_by_expr )+ ) ;
    public final LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        LogicalPlanGenerator.join_group_by_clause_return retval = new LogicalPlanGenerator.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY274=null;
        LogicalPlanGenerator.join_group_by_expr_return join_group_by_expr275 =null;


        CommonTree BY274_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1257:2: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1257:4: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY274=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause3913); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY274_tree = (CommonTree)adaptor.dupNode(BY274);


            root_1 = (CommonTree)adaptor.becomeRoot(BY274_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1257:10: ( join_group_by_expr )+
            int cnt94=0;
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==CUBE||LA94_0==DIV||LA94_0==DOLLARVAR||LA94_0==DOUBLENUMBER||LA94_0==FALSE||LA94_0==FLOATNUMBER||LA94_0==GROUP||LA94_0==INTEGER||LA94_0==LONGINTEGER||LA94_0==MINUS||LA94_0==PERCENT||LA94_0==PLUS||LA94_0==QUOTEDSTRING||LA94_0==STAR||LA94_0==TRUE||(LA94_0 >= BAG_VAL && LA94_0 <= BIN_EXPR)||(LA94_0 >= CAST_EXPR && LA94_0 <= EXPR_IN_PAREN)||LA94_0==FUNC_EVAL||LA94_0==IDENTIFIER||(LA94_0 >= MAP_VAL && LA94_0 <= NEG)||LA94_0==NULL||LA94_0==TUPLE_VAL) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1257:12: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause3917);
            	    join_group_by_expr275=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr275.getTree());


            	    if ( state.backtracking==0 ) { retval.plans.add( (join_group_by_expr275!=null?join_group_by_expr275.plan:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt94 >= 1 ) break loop94;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(94, input);
                        throw eee;
                }
                cnt94++;
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
        public LogicalExpressionPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1260:1: join_group_by_expr returns [LogicalExpressionPlan plan] : ( col_range[$plan] | expr[$plan] | STAR );
    public final LogicalPlanGenerator.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        LogicalPlanGenerator.join_group_by_expr_return retval = new LogicalPlanGenerator.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR278=null;
        LogicalPlanGenerator.col_range_return col_range276 =null;

        LogicalPlanGenerator.expr_return expr277 =null;


        CommonTree STAR278_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1264:2: ( col_range[$plan] | expr[$plan] | STAR )
            int alt95=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt95=1;
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
                alt95=2;
                }
                break;
            case STAR:
                {
                int LA95_3 = input.LA(2);

                if ( (LA95_3==DOWN) ) {
                    alt95=2;
                }
                else if ( (LA95_3==EOF||LA95_3==UP||LA95_3==CUBE||LA95_3==DIV||LA95_3==DOLLARVAR||LA95_3==DOUBLENUMBER||LA95_3==FALSE||LA95_3==FLOATNUMBER||LA95_3==GROUP||LA95_3==INTEGER||LA95_3==LONGINTEGER||LA95_3==MINUS||LA95_3==PERCENT||LA95_3==PLUS||LA95_3==QUOTEDSTRING||LA95_3==STAR||LA95_3==TRUE||(LA95_3 >= BAG_VAL && LA95_3 <= BIN_EXPR)||(LA95_3 >= CAST_EXPR && LA95_3 <= EXPR_IN_PAREN)||LA95_3==FUNC_EVAL||LA95_3==IDENTIFIER||(LA95_3 >= MAP_VAL && LA95_3 <= NEG)||LA95_3==NULL||LA95_3==TUPLE_VAL) ) {
                    alt95=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 95, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;

            }

            switch (alt95) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1264:4: col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr3942);
                    col_range276=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range276.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1265:4: expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr3948);
                    expr277=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr277.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1266:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR278=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr3954); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR278_tree = (CommonTree)adaptor.dupNode(STAR278);


                    adaptor.addChild(root_0, STAR278_tree);
                    }


                    if ( state.backtracking==0 ) {
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR278 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp, 
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1273:1: union_clause returns [String alias] : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final LogicalPlanGenerator.union_clause_return union_clause() throws RecognitionException {
        LogicalPlanGenerator.union_clause_return retval = new LogicalPlanGenerator.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION279=null;
        CommonTree ONSCHEMA280=null;
        LogicalPlanGenerator.rel_list_return rel_list281 =null;


        CommonTree UNION279_tree=null;
        CommonTree ONSCHEMA280_tree=null;


            boolean onSchema = false;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1277:2: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1277:4: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION279=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause3980); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION279_tree = (CommonTree)adaptor.dupNode(UNION279);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION279_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1277:13: ( ONSCHEMA )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==ONSCHEMA) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1277:15: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA280=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause3984); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA280_tree = (CommonTree)adaptor.dupNode(ONSCHEMA280);


                    adaptor.addChild(root_1, ONSCHEMA280_tree);
                    }


                    if ( state.backtracking==0 ) { onSchema = true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause3991);
            rel_list281=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list281.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                  retval.alias = builder.buildUnionOp( new SourceLocation( (PigParserNode)UNION279 ), ((statement_scope)statement_stack.peek()).alias, 
                      (rel_list281!=null?rel_list281.aliasList:null), onSchema );
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


    protected static class foreach_clause_scope {
        LOForEach foreachOp;
    }
    protected Stack foreach_clause_stack = new Stack();


    public static class foreach_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1284:1: foreach_clause returns [String alias] : ^( FOREACH rel foreach_plan ) ;
    public final LogicalPlanGenerator.foreach_clause_return foreach_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        foreach_clause_stack.push(new foreach_clause_scope());
        LogicalPlanGenerator.foreach_clause_return retval = new LogicalPlanGenerator.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH282=null;
        LogicalPlanGenerator.rel_return rel283 =null;

        LogicalPlanGenerator.foreach_plan_return foreach_plan284 =null;


        CommonTree FOREACH282_tree=null;


             ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp = builder.createForeachOp();
             ((GScope_scope)GScope_stack.peek()).currentOp = ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1293:2: ( ^( FOREACH rel foreach_plan ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1293:4: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH282=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause4027); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH282_tree = (CommonTree)adaptor.dupNode(FOREACH282);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH282_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause4029);
            rel283=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel283.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause4031);
            foreach_plan284=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan284.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)FOREACH282 );
                   retval.alias = builder.buildForeachOp( loc, ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (foreach_plan284!=null?foreach_plan284.plan:null) );
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
            GScope_stack.pop();
            foreach_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "foreach_clause"


    protected static class foreach_plan_scope {
        LogicalPlan innerPlan;
        Map<String, LogicalExpressionPlan> exprPlans;
        Map<String, Operator> operators;
    }
    protected Stack foreach_plan_stack = new Stack();


    public static class foreach_plan_return extends TreeRuleReturnScope {
        public LogicalPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_plan"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1301:1: foreach_plan returns [LogicalPlan plan] : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final LogicalPlanGenerator.foreach_plan_return foreach_plan() throws RecognitionException {
        foreach_plan_stack.push(new foreach_plan_scope());
        LogicalPlanGenerator.foreach_plan_return retval = new LogicalPlanGenerator.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE285=null;
        CommonTree FOREACH_PLAN_COMPLEX287=null;
        LogicalPlanGenerator.generate_clause_return generate_clause286 =null;

        LogicalPlanGenerator.nested_blk_return nested_blk288 =null;


        CommonTree FOREACH_PLAN_SIMPLE285_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX287_tree=null;


            inForeachPlan = true;
            ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan = new LogicalPlan();
            ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans = new HashMap<String, LogicalExpressionPlan>();
            ((foreach_plan_scope)foreach_plan_stack.peek()).operators = new HashMap<String, Operator>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1317:2: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==FOREACH_PLAN_SIMPLE) ) {
                alt97=1;
            }
            else if ( (LA97_0==FOREACH_PLAN_COMPLEX) ) {
                alt97=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;

            }
            switch (alt97) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1317:4: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE285=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan4067); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE285_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE285);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE285_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan4069);
                    generate_clause286=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause286.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1318:4: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX287=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan4078); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX287_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX287);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX287_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan4080);
                    nested_blk288=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk288.getTree());


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

            if ( state.backtracking==0 ) {
                retval.plan = ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan;
                inForeachPlan = false;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            foreach_plan_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "foreach_plan"


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1321:1: nested_blk : ( nested_command )* generate_clause ;
    public final LogicalPlanGenerator.nested_blk_return nested_blk() throws RecognitionException {
        LogicalPlanGenerator.nested_blk_return retval = new LogicalPlanGenerator.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_command_return nested_command289 =null;

        LogicalPlanGenerator.generate_clause_return generate_clause290 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1321:12: ( ( nested_command )* generate_clause )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1321:14: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1321:14: ( nested_command )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( ((LA98_0 >= NESTED_CMD && LA98_0 <= NESTED_CMD_ASSI)) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1321:14: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk4091);
            	    nested_command289=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command289.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop98;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk4094);
            generate_clause290=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause290.getTree());


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


    public static class nested_command_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_command"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1324:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) );
    public final LogicalPlanGenerator.nested_command_return nested_command() throws RecognitionException {
        LogicalPlanGenerator.nested_command_return retval = new LogicalPlanGenerator.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD291=null;
        CommonTree IDENTIFIER292=null;
        CommonTree NESTED_CMD_ASSI294=null;
        CommonTree IDENTIFIER295=null;
        LogicalPlanGenerator.nested_op_return nested_op293 =null;

        LogicalPlanGenerator.expr_return expr296 =null;


        CommonTree NESTED_CMD291_tree=null;
        CommonTree IDENTIFIER292_tree=null;
        CommonTree NESTED_CMD_ASSI294_tree=null;
        CommonTree IDENTIFIER295_tree=null;


            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            inNestedCommand = true;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1332:2: ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==NESTED_CMD) ) {
                alt99=1;
            }
            else if ( (LA99_0==NESTED_CMD_ASSI) ) {
                alt99=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;

            }
            switch (alt99) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1332:4: ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD291=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command4116); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD291_tree = (CommonTree)adaptor.dupNode(NESTED_CMD291);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD291_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER292=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command4118); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER292_tree = (CommonTree)adaptor.dupNode(IDENTIFIER292);


                    adaptor.addChild(root_1, IDENTIFIER292_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command4120);
                    nested_op293=nested_op((IDENTIFIER292!=null?IDENTIFIER292.getText():null));

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op293.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((foreach_plan_scope)foreach_plan_stack.peek()).operators.put( (IDENTIFIER292!=null?IDENTIFIER292.getText():null), (nested_op293!=null?nested_op293.op:null) );
                           ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans.remove( (IDENTIFIER292!=null?IDENTIFIER292.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1338:4: ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI294=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command4139); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI294_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI294);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI294_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER295=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command4141); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER295_tree = (CommonTree)adaptor.dupNode(IDENTIFIER295);


                    adaptor.addChild(root_1, IDENTIFIER295_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command4143);
                    expr296=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr296.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                            ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans.put( (IDENTIFIER295!=null?IDENTIFIER295.getText():null), exprPlan );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
            	inNestedCommand = false;
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
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1344:1: nested_op[String alias] returns [Operator op] : ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] );
    public final LogicalPlanGenerator.nested_op_return nested_op(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_op_return retval = new LogicalPlanGenerator.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_proj_return nested_proj297 =null;

        LogicalPlanGenerator.nested_filter_return nested_filter298 =null;

        LogicalPlanGenerator.nested_sort_return nested_sort299 =null;

        LogicalPlanGenerator.nested_distinct_return nested_distinct300 =null;

        LogicalPlanGenerator.nested_limit_return nested_limit301 =null;

        LogicalPlanGenerator.nested_cross_return nested_cross302 =null;

        LogicalPlanGenerator.nested_foreach_return nested_foreach303 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1345:2: ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] )
            int alt100=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt100=1;
                }
                break;
            case FILTER:
                {
                alt100=2;
                }
                break;
            case ORDER:
                {
                alt100=3;
                }
                break;
            case DISTINCT:
                {
                alt100=4;
                }
                break;
            case LIMIT:
                {
                alt100=5;
                }
                break;
            case CROSS:
                {
                alt100=6;
                }
                break;
            case FOREACH:
                {
                alt100=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;

            }

            switch (alt100) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1345:4: nested_proj[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op4165);
                    nested_proj297=nested_proj(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj297.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_proj297!=null?nested_proj297.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1346:4: nested_filter[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op4173);
                    nested_filter298=nested_filter(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter298.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_filter298!=null?nested_filter298.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1347:4: nested_sort[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op4181);
                    nested_sort299=nested_sort(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort299.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_sort299!=null?nested_sort299.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1348:4: nested_distinct[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op4190);
                    nested_distinct300=nested_distinct(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct300.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_distinct300!=null?nested_distinct300.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1349:4: nested_limit[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op4198);
                    nested_limit301=nested_limit(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit301.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_limit301!=null?nested_limit301.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1350:4: nested_cross[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op4206);
                    nested_cross302=nested_cross(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross302.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_cross302!=null?nested_cross302.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1351:4: nested_foreach[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op4214);
                    nested_foreach303=nested_foreach(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach303.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_foreach303!=null?nested_foreach303.op:null); }

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
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_proj"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1354:1: nested_proj[String alias] returns [Operator op] : ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) ;
    public final LogicalPlanGenerator.nested_proj_return nested_proj(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_proj_return retval = new LogicalPlanGenerator.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ304=null;
        LogicalPlanGenerator.col_ref_return cr0 =null;

        LogicalPlanGenerator.col_ref_return cr =null;


        CommonTree NESTED_PROJ304_tree=null;


            LogicalExpressionPlan plan = new LogicalExpressionPlan();
            List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1359:2: ( ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1359:4: ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ304=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj4238); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ304_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ304);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ304_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj4250);
            cr0=col_ref(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cr0.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1361:7: (cr= col_ref[new LogicalExpressionPlan()] )+
            int cnt101=0;
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==CUBE||LA101_0==DOLLARVAR||LA101_0==GROUP||LA101_0==IDENTIFIER) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1361:9: cr= col_ref[new LogicalExpressionPlan()]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj4265);
            	    cr=col_ref(new LogicalExpressionPlan());

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, cr.getTree());


            	    if ( state.backtracking==0 ) {
            	                plans.add( (LogicalExpressionPlan)( (cr!=null?cr.expr:null).getPlan() ) );
            	            }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt101 >= 1 ) break loop101;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(101, input);
                        throw eee;
                }
                cnt101++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(cr0!=null?((CommonTree)cr0.start):null) );
                   retval.op = builder.buildNestedProjectOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, 
                       ((foreach_plan_scope)foreach_plan_stack.peek()).operators, alias, (ProjectExpression)(cr0!=null?cr0.expr:null), plans );
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
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1373:1: nested_filter[String alias] returns [Operator op] : ^( FILTER nested_op_input cond[plan] ) ;
    public final LogicalPlanGenerator.nested_filter_return nested_filter(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_filter_return retval = new LogicalPlanGenerator.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER305=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input306 =null;

        LogicalPlanGenerator.cond_return cond307 =null;


        CommonTree FILTER305_tree=null;


            LogicalExpressionPlan plan = new LogicalExpressionPlan();
            Operator inputOp = null;
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedFilterOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1380:2: ( ^( FILTER nested_op_input cond[plan] ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1380:4: ^( FILTER nested_op_input cond[plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER305=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter4318); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER305_tree = (CommonTree)adaptor.dupNode(FILTER305);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER305_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter4320);
            nested_op_input306=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input306.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter4322);
            cond307=cond(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond307.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)FILTER305 );
                   retval.op = builder.buildNestedFilterOp( loc, (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, 
                       (nested_op_input306!=null?nested_op_input306.op:null), plan );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_filter"


    public static class nested_sort_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_sort"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1388:1: nested_sort[String alias] returns [Operator op] : ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
    public final LogicalPlanGenerator.nested_sort_return nested_sort(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_sort_return retval = new LogicalPlanGenerator.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER308=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input309 =null;

        LogicalPlanGenerator.order_by_clause_return order_by_clause310 =null;

        LogicalPlanGenerator.func_clause_return func_clause311 =null;


        CommonTree ORDER308_tree=null;


            Operator inputOp = null;
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedSortOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1394:2: ( ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1394:4: ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER308=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort4356); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER308_tree = (CommonTree)adaptor.dupNode(ORDER308);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER308_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort4358);
            nested_op_input309=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input309.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort4360);
            order_by_clause310=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause310.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1394:45: ( func_clause[FunctionType.COMPARISONFUNC] )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==FUNC||LA102_0==FUNC_REF) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1394:45: func_clause[FunctionType.COMPARISONFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort4362);
                    func_clause311=func_clause(FunctionType.COMPARISONFUNC);

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
                   SourceLocation loc = new SourceLocation( (PigParserNode)ORDER308 );
                   retval.op = builder.buildNestedSortOp( loc, (LOSort)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                       (nested_op_input309!=null?nested_op_input309.op:null), 
                       (order_by_clause310!=null?order_by_clause310.plans:null), (order_by_clause310!=null?order_by_clause310.ascFlags:null), (func_clause311!=null?func_clause311.funcSpec:null) );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_sort"


    public static class nested_distinct_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_distinct"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1403:1: nested_distinct[String alias] returns [Operator op] : ^( DISTINCT nested_op_input ) ;
    public final LogicalPlanGenerator.nested_distinct_return nested_distinct(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_distinct_return retval = new LogicalPlanGenerator.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT312=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input313 =null;


        CommonTree DISTINCT312_tree=null;


            Operator inputOp = null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1407:2: ( ^( DISTINCT nested_op_input ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1407:4: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT312=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct4392); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT312_tree = (CommonTree)adaptor.dupNode(DISTINCT312);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT312_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct4394);
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
                   SourceLocation loc = new SourceLocation( (PigParserNode)DISTINCT312 );
                   retval.op = builder.buildNestedDistinctOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input313!=null?nested_op_input313.op:null) );
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
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_limit"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1414:1: nested_limit[String alias] returns [Operator op] : ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.nested_limit_return nested_limit(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_limit_return retval = new LogicalPlanGenerator.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT314=null;
        CommonTree INTEGER316=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input315 =null;

        LogicalPlanGenerator.expr_return expr317 =null;


        CommonTree LIMIT314_tree=null;
        CommonTree INTEGER316_tree=null;


            Operator inputOp = null;
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedLimitOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1421:2: ( ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1421:4: ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT314=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit4427); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT314_tree = (CommonTree)adaptor.dupNode(LIMIT314);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT314_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit4429);
            nested_op_input315=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input315.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1421:29: ( INTEGER | expr[exprPlan] )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==INTEGER) ) {
                int LA103_1 = input.LA(2);

                if ( (synpred177_LogicalPlanGenerator()) ) {
                    alt103=1;
                }
                else if ( (true) ) {
                    alt103=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 103, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA103_0==CUBE||LA103_0==DIV||LA103_0==DOLLARVAR||LA103_0==DOUBLENUMBER||LA103_0==FALSE||LA103_0==FLOATNUMBER||LA103_0==GROUP||LA103_0==LONGINTEGER||LA103_0==MINUS||LA103_0==PERCENT||LA103_0==PLUS||LA103_0==QUOTEDSTRING||LA103_0==STAR||LA103_0==TRUE||(LA103_0 >= BAG_VAL && LA103_0 <= BIN_EXPR)||LA103_0==CAST_EXPR||LA103_0==EXPR_IN_PAREN||LA103_0==FUNC_EVAL||LA103_0==IDENTIFIER||(LA103_0 >= MAP_VAL && LA103_0 <= NEG)||LA103_0==NULL||LA103_0==TUPLE_VAL) ) {
                alt103=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;

            }
            switch (alt103) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1421:31: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER316=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit4433); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER316_tree = (CommonTree)adaptor.dupNode(INTEGER316);


                    adaptor.addChild(root_1, INTEGER316_tree);
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)LIMIT314 );
                           retval.op = builder.buildNestedLimitOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input315!=null?nested_op_input315.op:null), 
                               Integer.valueOf( (INTEGER316!=null?INTEGER316.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1427:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit4444);
                    expr317=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr317.getTree());


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)LIMIT314 );
                           retval.op = builder.buildNestedLimitOp( loc, (LOLimit)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                               (nested_op_input315!=null?nested_op_input315.op:null), exprPlan);
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_limit"


    public static class nested_cross_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_cross"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1436:1: nested_cross[String alias] returns [Operator op] : ^( CROSS nested_op_input_list ) ;
    public final LogicalPlanGenerator.nested_cross_return nested_cross(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_cross_return retval = new LogicalPlanGenerator.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS318=null;
        LogicalPlanGenerator.nested_op_input_list_return nested_op_input_list319 =null;


        CommonTree CROSS318_tree=null;


            Operator inputOp = null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1440:2: ( ^( CROSS nested_op_input_list ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1440:4: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS318=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross4478); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS318_tree = (CommonTree)adaptor.dupNode(CROSS318);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS318_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross4480);
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
                   SourceLocation loc = new SourceLocation( (PigParserNode)CROSS318 );
                   retval.op = builder.buildNestedCrossOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input_list319!=null?nested_op_input_list319.opList:null) );
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


    protected static class nested_foreach_scope {
        LogicalPlan innerPlan;
        LOForEach foreachOp;
    }
    protected Stack nested_foreach_stack = new Stack();


    public static class nested_foreach_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_foreach"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1447:1: nested_foreach[String alias] returns [Operator op] : ^( FOREACH nested_op_input generate_clause ) ;
    public final LogicalPlanGenerator.nested_foreach_return nested_foreach(String alias) throws RecognitionException {
        nested_foreach_stack.push(new nested_foreach_scope());
        LogicalPlanGenerator.nested_foreach_return retval = new LogicalPlanGenerator.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH320=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input321 =null;

        LogicalPlanGenerator.generate_clause_return generate_clause322 =null;


        CommonTree FOREACH320_tree=null;


        	Operator inputOp = null;
        	((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan = new LogicalPlan();
        	((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp = builder.createNestedForeachOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1457:2: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1457:4: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH320=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach4512); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH320_tree = (CommonTree)adaptor.dupNode(FOREACH320);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH320_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach4514);
            nested_op_input321=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input321.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach4516);
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
               		SourceLocation loc = new SourceLocation( (PigParserNode)FOREACH320 );
               		retval.op = builder.buildNestedForeachOp( loc, (LOForEach)((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan,
               							alias, (nested_op_input321!=null?nested_op_input321.op:null), ((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan);
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
            nested_foreach_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "nested_foreach"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1465:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final LogicalPlanGenerator.generate_clause_return generate_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.generate_clause_return retval = new LogicalPlanGenerator.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE323=null;
        LogicalPlanGenerator.flatten_generated_item_return flatten_generated_item324 =null;


        CommonTree GENERATE323_tree=null;


        	((GScope_scope)GScope_stack.peek()).currentOp = builder.createGenerateOp(inNestedCommand ? ((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan : ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );
            List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();
            List<Boolean> flattenFlags = new ArrayList<Boolean>();
            List<LogicalSchema> schemas = new ArrayList<LogicalSchema>();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1473:2: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1473:4: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE323=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause4545); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE323_tree = (CommonTree)adaptor.dupNode(GENERATE323);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE323_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1473:16: ( flatten_generated_item )+
            int cnt104=0;
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==CUBE||LA104_0==DIV||LA104_0==DOLLARVAR||LA104_0==DOUBLENUMBER||LA104_0==FALSE||LA104_0==FLATTEN||LA104_0==FLOATNUMBER||LA104_0==GROUP||LA104_0==INTEGER||LA104_0==LONGINTEGER||LA104_0==MINUS||LA104_0==PERCENT||LA104_0==PLUS||LA104_0==QUOTEDSTRING||LA104_0==STAR||LA104_0==TRUE||(LA104_0 >= BAG_VAL && LA104_0 <= BIN_EXPR)||(LA104_0 >= CAST_EXPR && LA104_0 <= EXPR_IN_PAREN)||LA104_0==FUNC_EVAL||LA104_0==IDENTIFIER||(LA104_0 >= MAP_VAL && LA104_0 <= NEG)||LA104_0==NULL||LA104_0==TUPLE_VAL) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1473:18: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause4549);
            	    flatten_generated_item324=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item324.getTree());


            	    if ( state.backtracking==0 ) {
            	                         plans.add( (flatten_generated_item324!=null?flatten_generated_item324.plan:null) );
            	                         flattenFlags.add( (flatten_generated_item324!=null?flatten_generated_item324.flattenFlag:false) );
            	                         schemas.add( (flatten_generated_item324!=null?flatten_generated_item324.schema:null) );
            	                     }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt104 >= 1 ) break loop104;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(104, input);
                        throw eee;
                }
                cnt104++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {   
                   builder.buildGenerateOp( new SourceLocation( (PigParserNode)GENERATE323 ), 
                   	   inNestedCommand ? ((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp : ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, 
                       (LOGenerate)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).operators,
                       plans, flattenFlags, schemas );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "generate_clause"


    public static class nested_op_input_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1489:1: nested_op_input returns [Operator op] : ( col_ref[plan] | nested_proj[null] );
    public final LogicalPlanGenerator.nested_op_input_return nested_op_input() throws RecognitionException {
        LogicalPlanGenerator.nested_op_input_return retval = new LogicalPlanGenerator.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.col_ref_return col_ref325 =null;

        LogicalPlanGenerator.nested_proj_return nested_proj326 =null;




            LogicalExpressionPlan plan = new LogicalExpressionPlan();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1493:2: ( col_ref[plan] | nested_proj[null] )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==CUBE||LA105_0==DOLLARVAR||LA105_0==GROUP||LA105_0==IDENTIFIER) ) {
                alt105=1;
            }
            else if ( (LA105_0==NESTED_PROJ) ) {
                alt105=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;

            }
            switch (alt105) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1493:4: col_ref[plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input4615);
                    col_ref325=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref325.getTree());


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)(col_ref325!=null?((CommonTree)col_ref325.start):null) );
                           retval.op = builder.buildNestedOperatorInput( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan,
                               ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, ((foreach_plan_scope)foreach_plan_stack.peek()).operators, (col_ref325!=null?col_ref325.expr:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1499:4: nested_proj[null]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input4626);
                    nested_proj326=nested_proj(null);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj326.getTree());


                    if ( state.backtracking==0 ) { 
                           retval.op = (nested_proj326!=null?nested_proj326.op:null);
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
    // $ANTLR end "nested_op_input"


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        public List<Operator> opList;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1505:1: nested_op_input_list returns [List<Operator> opList] : ( nested_op_input )+ ;
    public final LogicalPlanGenerator.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        LogicalPlanGenerator.nested_op_input_list_return retval = new LogicalPlanGenerator.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_op_input_return nested_op_input327 =null;



         retval.opList = new ArrayList<Operator>(); 
        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1507:2: ( ( nested_op_input )+ )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1507:4: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1507:4: ( nested_op_input )+
            int cnt106=0;
            loop106:
            do {
                int alt106=2;
                int LA106_0 = input.LA(1);

                if ( (LA106_0==CUBE||LA106_0==DOLLARVAR||LA106_0==GROUP||LA106_0==IDENTIFIER||LA106_0==NESTED_PROJ) ) {
                    alt106=1;
                }


                switch (alt106) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1507:6: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list4652);
            	    nested_op_input327=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input327.getTree());


            	    if ( state.backtracking==0 ) { retval.opList.add( (nested_op_input327!=null?nested_op_input327.op:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt106 >= 1 ) break loop106;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(106, input);
                        throw eee;
                }
                cnt106++;
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


    public static class stream_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1510:1: stream_clause returns [String alias] : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final LogicalPlanGenerator.stream_clause_return stream_clause() throws RecognitionException {
        LogicalPlanGenerator.stream_clause_return retval = new LogicalPlanGenerator.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM328=null;
        CommonTree EXECCOMMAND330=null;
        CommonTree IDENTIFIER331=null;
        LogicalPlanGenerator.rel_return rel329 =null;

        LogicalPlanGenerator.as_clause_return as_clause332 =null;


        CommonTree STREAM328_tree=null;
        CommonTree EXECCOMMAND330_tree=null;
        CommonTree IDENTIFIER331_tree=null;


            StreamingCommand cmd = null;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1515:2: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1515:4: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM328=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause4677); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM328_tree = (CommonTree)adaptor.dupNode(STREAM328);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM328_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause4679);
            rel329=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel329.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1515:18: ( EXECCOMMAND | IDENTIFIER )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==EXECCOMMAND) ) {
                alt107=1;
            }
            else if ( (LA107_0==IDENTIFIER) ) {
                alt107=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;

            }
            switch (alt107) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1515:20: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND330=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_stream_clause4683); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND330_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND330);


                    adaptor.addChild(root_1, EXECCOMMAND330_tree);
                    }


                    if ( state.backtracking==0 ) { cmd = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND330!=null?EXECCOMMAND330.getText():null) ) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1516:20: IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER331=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stream_clause4707); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER331_tree = (CommonTree)adaptor.dupNode(IDENTIFIER331);


                    adaptor.addChild(root_1, IDENTIFIER331_tree);
                    }


                    if ( state.backtracking==0 ) { 
                                           cmd = builder.lookupCommand( (IDENTIFIER331!=null?IDENTIFIER331.getText():null) );
                                           if( cmd == null ) {
                                               String msg = "Undefined command-alias [" + (IDENTIFIER331!=null?IDENTIFIER331.getText():null) + "]";
                                               throw new ParserValidationException( input, 
                                                   new SourceLocation( (PigParserNode)IDENTIFIER331 ), msg );
                                           }
                                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1525:20: ( as_clause )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==AS) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1525:20: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause4750);
                    as_clause332=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause332.getTree());


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
                   retval.alias = builder.buildStreamOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, cmd, (as_clause332!=null?as_clause332.logicalSchema:null), input );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mr_clause"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1532:1: mr_clause returns [String alias] : ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final LogicalPlanGenerator.mr_clause_return mr_clause() throws RecognitionException {
        LogicalPlanGenerator.mr_clause_return retval = new LogicalPlanGenerator.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE333=null;
        CommonTree QUOTEDSTRING334=null;
        CommonTree EXECCOMMAND338=null;
        LogicalPlanGenerator.path_list_return path_list335 =null;

        LogicalPlanGenerator.store_clause_return store_clause336 =null;

        LogicalPlanGenerator.load_clause_return load_clause337 =null;


        CommonTree MAPREDUCE333_tree=null;
        CommonTree QUOTEDSTRING334_tree=null;
        CommonTree EXECCOMMAND338_tree=null;


            List<String> paths = new ArrayList<String>();
            String alias = ((statement_scope)statement_stack.peek()).alias;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1538:2: ( ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1538:4: ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE333=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause4778); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE333_tree = (CommonTree)adaptor.dupNode(MAPREDUCE333);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE333_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING334=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause4780); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING334_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING334);


            adaptor.addChild(root_1, QUOTEDSTRING334_tree);
            }


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1538:30: ( path_list[paths] )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==QUOTEDSTRING) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1538:30: path_list[paths]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause4782);
                    path_list335=path_list(paths);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list335.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = null; }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause4794);
            store_clause336=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause336.getTree());


            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = alias; }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause4804);
            load_clause337=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause337.getTree());


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1541:6: ( EXECCOMMAND )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==EXECCOMMAND) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1541:6: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND338=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause4811); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND338_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND338);


                    adaptor.addChild(root_1, EXECCOMMAND338_tree);
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
                   retval.alias = builder.buildNativeOp( loc,
                       builder.unquote( (QUOTEDSTRING334!=null?QUOTEDSTRING334.getText():null) ), builder.unquote( (EXECCOMMAND338!=null?EXECCOMMAND338.getText():null) ), 
                       paths, (store_clause336!=null?store_clause336.alias:null), (load_clause337!=null?load_clause337.alias:null), input );
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1549:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final LogicalPlanGenerator.split_clause_return split_clause() throws RecognitionException {
        LogicalPlanGenerator.split_clause_return retval = new LogicalPlanGenerator.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT339=null;
        LogicalPlanGenerator.rel_return rel340 =null;

        LogicalPlanGenerator.split_branch_return split_branch341 =null;

        LogicalPlanGenerator.split_otherwise_return split_otherwise342 =null;


        CommonTree SPLIT339_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1550:2: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1550:4: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT339=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause4831); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT339_tree = (CommonTree)adaptor.dupNode(SPLIT339);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT339_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause4839);
            rel340=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel340.getTree());


            if ( state.backtracking==0 ) { 
                      SourceLocation loc = new SourceLocation( (PigParserNode)SPLIT339 );
                      ((statement_scope)statement_stack.peek()).inputAlias = builder.buildSplitOp( loc, ((statement_scope)statement_stack.peek()).inputAlias );
                  }

            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1556:7: ( split_branch )+
            int cnt111=0;
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( (LA111_0==SPLIT_BRANCH) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1556:7: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause4857);
            	    split_branch341=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch341.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt111 >= 1 ) break loop111;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(111, input);
                        throw eee;
                }
                cnt111++;
            } while (true);


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1556:21: ( split_otherwise )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==OTHERWISE) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1556:21: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause4860);
                    split_otherwise342=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise342.getTree());


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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1560:1: split_branch : ^( SPLIT_BRANCH alias cond[splitPlan] ) ;
    public final LogicalPlanGenerator.split_branch_return split_branch() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.split_branch_return retval = new LogicalPlanGenerator.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH343=null;
        LogicalPlanGenerator.alias_return alias344 =null;

        LogicalPlanGenerator.cond_return cond345 =null;


        CommonTree SPLIT_BRANCH343_tree=null;


            LogicalExpressionPlan splitPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSplitOutputOp();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1566:2: ( ^( SPLIT_BRANCH alias cond[splitPlan] ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1566:4: ^( SPLIT_BRANCH alias cond[splitPlan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH343=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch4889); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH343_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH343);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH343_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch4891);
            alias344=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias344.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch4893);
            cond345=cond(splitPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond345.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(alias344!=null?((CommonTree)alias344.start):null) );
                   builder.buildSplitOutputOp( loc, (LOSplitOutput)((GScope_scope)GScope_stack.peek()).currentOp, (alias344!=null?alias344.name:null),
                       ((statement_scope)statement_stack.peek()).inputAlias, splitPlan );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "split_branch"


    public static class split_otherwise_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_otherwise"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1574:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final LogicalPlanGenerator.split_otherwise_return split_otherwise() throws RecognitionException, PlanGenerationFailureException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.split_otherwise_return retval = new LogicalPlanGenerator.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE346=null;
        LogicalPlanGenerator.alias_return alias347 =null;


        CommonTree OTHERWISE346_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSplitOutputOp();

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1579:2: ( ^( OTHERWISE alias ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1579:4: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE346=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise4927); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE346_tree = (CommonTree)adaptor.dupNode(OTHERWISE346);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE346_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise4929);
            alias347=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias347.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(alias347!=null?((CommonTree)alias347.start):null) );
                   builder.buildSplitOtherwiseOp( loc, (LOSplitOutput)((GScope_scope)GScope_stack.peek()).currentOp, (alias347!=null?alias347.name:null),
                       ((statement_scope)statement_stack.peek()).inputAlias);
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "split_otherwise"


    public static class col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_ref"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1587:1: col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( alias_col_ref[$plan] | dollar_col_ref[$plan] );
    public final LogicalPlanGenerator.col_ref_return col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.col_ref_return retval = new LogicalPlanGenerator.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.alias_col_ref_return alias_col_ref348 =null;

        LogicalPlanGenerator.dollar_col_ref_return dollar_col_ref349 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1588:2: ( alias_col_ref[$plan] | dollar_col_ref[$plan] )
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==CUBE||LA113_0==GROUP||LA113_0==IDENTIFIER) ) {
                alt113=1;
            }
            else if ( (LA113_0==DOLLARVAR) ) {
                alt113=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;

            }
            switch (alt113) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1588:4: alias_col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref4950);
                    alias_col_ref348=alias_col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref348.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (alias_col_ref348!=null?alias_col_ref348.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1589:4: dollar_col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref4958);
                    dollar_col_ref349=dollar_col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref349.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (dollar_col_ref349!=null?dollar_col_ref349.expr:null); }

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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias_col_ref"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1592:1: alias_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( GROUP | CUBE | IDENTIFIER );
    public final LogicalPlanGenerator.alias_col_ref_return alias_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.alias_col_ref_return retval = new LogicalPlanGenerator.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP350=null;
        CommonTree CUBE351=null;
        CommonTree IDENTIFIER352=null;

        CommonTree GROUP350_tree=null;
        CommonTree CUBE351_tree=null;
        CommonTree IDENTIFIER352_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1593:2: ( GROUP | CUBE | IDENTIFIER )
            int alt114=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt114=1;
                }
                break;
            case CUBE:
                {
                alt114=2;
                }
                break;
            case IDENTIFIER:
                {
                alt114=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;

            }

            switch (alt114) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1593:4: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP350=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref4975); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP350_tree = (CommonTree)adaptor.dupNode(GROUP350);


                    adaptor.addChild(root_0, GROUP350_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)GROUP350 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp, 
                               ((statement_scope)statement_stack.peek()).inputIndex, (GROUP350!=null?GROUP350.getText():null), 0 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1598:4: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE351=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref4986); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE351_tree = (CommonTree)adaptor.dupNode(CUBE351);


                    adaptor.addChild(root_0, CUBE351_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)CUBE351 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp, 
                               ((statement_scope)statement_stack.peek()).inputIndex, (CUBE351!=null?CUBE351.getText():null), 0 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1603:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER352=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref4997); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER352_tree = (CommonTree)adaptor.dupNode(IDENTIFIER352);


                    adaptor.addChild(root_0, IDENTIFIER352_tree);
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)IDENTIFIER352 );
                           String alias = (IDENTIFIER352!=null?IDENTIFIER352.getText():null);
                           Operator inOp = builder.lookupOperator( ((statement_scope)statement_stack.peek()).inputAlias );
                           if(null == inOp)
                           {
                               throw new UndefinedAliasException (input,loc,((statement_scope)statement_stack.peek()).inputAlias);
                           }
                           LogicalSchema schema;
                           try {
                               schema = ((LogicalRelationalOperator)inOp).getSchema();
                           } catch (FrontendException e) {
                               throw new PlanGenerationFailureException( input, loc, e );
                           }
                           
                           Operator op = builder.lookupOperator( alias );
                           if( op != null && ( schema == null || schema.getFieldPosition( alias ) == -1 ) ) {
                               retval.expr = new ScalarExpression( plan, op,
                                   inForeachPlan ? ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp : ((GScope_scope)GScope_stack.peek()).currentOp );
                               retval.expr.setLocation( loc );
                           } else {
                               if( inForeachPlan ) {
                                   retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp, 
                                       ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans, alias, 0 );
                               } else {
                                   retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp, 
                                       ((statement_scope)statement_stack.peek()).inputIndex, alias, 0 );
                               }
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
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1636:1: dollar_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : DOLLARVAR ;
    public final LogicalPlanGenerator.dollar_col_ref_return dollar_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.dollar_col_ref_return retval = new LogicalPlanGenerator.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR353=null;

        CommonTree DOLLARVAR353_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1637:2: ( DOLLARVAR )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1637:4: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR353=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref5016); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR353_tree = (CommonTree)adaptor.dupNode(DOLLARVAR353);


            adaptor.addChild(root_0, DOLLARVAR353_tree);
            }


            if ( state.backtracking==0 ) {
                   int col = builder.undollar( (DOLLARVAR353!=null?DOLLARVAR353.getText():null) );
                   retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)DOLLARVAR353 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp, 
                       ((statement_scope)statement_stack.peek()).inputIndex, null, col );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1645:1: const_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : literal ;
    public final LogicalPlanGenerator.const_expr_return const_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.const_expr_return retval = new LogicalPlanGenerator.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.literal_return literal354 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1646:2: ( literal )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1646:4: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr5035);
            literal354=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal354.getTree());


            if ( state.backtracking==0 ) {
                   retval.expr = new ConstantExpression( plan, (literal354!=null?literal354.value:null));
                   retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
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
    // $ANTLR end "const_expr"


    public static class literal_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1653:1: literal returns [Object value, byte type] : ( scalar | map | bag | tuple );
    public final LogicalPlanGenerator.literal_return literal() throws RecognitionException {
        LogicalPlanGenerator.literal_return retval = new LogicalPlanGenerator.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.scalar_return scalar355 =null;

        LogicalPlanGenerator.map_return map356 =null;

        LogicalPlanGenerator.bag_return bag357 =null;

        LogicalPlanGenerator.tuple_return tuple358 =null;



        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1654:2: ( scalar | map | bag | tuple )
            int alt115=4;
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
                alt115=1;
                }
                break;
            case MAP_VAL:
                {
                alt115=2;
                }
                break;
            case BAG_VAL:
                {
                alt115=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt115=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;

            }

            switch (alt115) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1654:4: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal5053);
                    scalar355=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar355.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (scalar355!=null?scalar355.value:null);
                           retval.type = (scalar355!=null?scalar355.type:0);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1659:4: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal5063);
                    map356=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map356.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (map356!=null?map356.value:null);
                           retval.type = DataType.MAP;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1664:4: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal5073);
                    bag357=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag357.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (bag357!=null?bag357.value:null);
                           retval.type = DataType.BAG;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1669:4: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal5083);
                    tuple358=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple358.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (tuple358!=null?tuple358.value:null);
                           retval.type = DataType.TUPLE;
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
    // $ANTLR end "literal"


    public static class scalar_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scalar"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1676:1: scalar returns [Object value, byte type] : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final LogicalPlanGenerator.scalar_return scalar() throws RecognitionException {
        LogicalPlanGenerator.scalar_return retval = new LogicalPlanGenerator.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING360=null;
        CommonTree NULL361=null;
        CommonTree TRUE362=null;
        CommonTree FALSE363=null;
        LogicalPlanGenerator.num_scalar_return num_scalar359 =null;


        CommonTree QUOTEDSTRING360_tree=null;
        CommonTree NULL361_tree=null;
        CommonTree TRUE362_tree=null;
        CommonTree FALSE363_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1677:2: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt116=5;
            switch ( input.LA(1) ) {
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt116=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt116=2;
                }
                break;
            case NULL:
                {
                alt116=3;
                }
                break;
            case TRUE:
                {
                alt116=4;
                }
                break;
            case FALSE:
                {
                alt116=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;

            }

            switch (alt116) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1677:4: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar5101);
                    num_scalar359=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar359.getTree());


                    if ( state.backtracking==0 ) {
                           retval.type = (num_scalar359!=null?num_scalar359.type:0);
                           retval.value = (num_scalar359!=null?num_scalar359.value:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1682:4: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING360=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar5111); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING360_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING360);


                    adaptor.addChild(root_0, QUOTEDSTRING360_tree);
                    }


                    if ( state.backtracking==0 ) { 
                           retval.type = DataType.CHARARRAY;
                           retval.value = builder.unquote( (QUOTEDSTRING360!=null?QUOTEDSTRING360.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1687:4: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL361=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar5122); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL361_tree = (CommonTree)adaptor.dupNode(NULL361);


                    adaptor.addChild(root_0, NULL361_tree);
                    }


                    if ( state.backtracking==0 ) { 
                           retval.type = DataType.NULL;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1691:4: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE362=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar5132); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE362_tree = (CommonTree)adaptor.dupNode(TRUE362);


                    adaptor.addChild(root_0, TRUE362_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.BOOLEAN;
                           retval.value = Boolean.TRUE;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1696:4: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE363=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar5142); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE363_tree = (CommonTree)adaptor.dupNode(FALSE363);


                    adaptor.addChild(root_0, FALSE363_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.BOOLEAN;
                           retval.value = Boolean.FALSE;
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
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1703:1: num_scalar returns [Object value, byte type] : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER ) ;
    public final LogicalPlanGenerator.num_scalar_return num_scalar() throws RecognitionException {
        LogicalPlanGenerator.num_scalar_return retval = new LogicalPlanGenerator.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS364=null;
        CommonTree INTEGER365=null;
        CommonTree LONGINTEGER366=null;
        CommonTree FLOATNUMBER367=null;
        CommonTree DOUBLENUMBER368=null;

        CommonTree MINUS364_tree=null;
        CommonTree INTEGER365_tree=null;
        CommonTree LONGINTEGER366_tree=null;
        CommonTree FLOATNUMBER367_tree=null;
        CommonTree DOUBLENUMBER368_tree=null;


            int sign = 1;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1707:2: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1707:4: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1707:4: ( MINUS )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==MINUS) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1707:6: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS364=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar5167); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS364_tree = (CommonTree)adaptor.dupNode(MINUS364);


                    adaptor.addChild(root_0, MINUS364_tree);
                    }


                    if ( state.backtracking==0 ) { sign = -1; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1708:4: ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER )
            int alt118=4;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt118=1;
                }
                break;
            case LONGINTEGER:
                {
                alt118=2;
                }
                break;
            case FLOATNUMBER:
                {
                alt118=3;
                }
                break;
            case DOUBLENUMBER:
                {
                alt118=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;

            }

            switch (alt118) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1708:6: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER365=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_num_scalar5180); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER365_tree = (CommonTree)adaptor.dupNode(INTEGER365);


                    adaptor.addChild(root_0, INTEGER365_tree);
                    }


                    if ( state.backtracking==0 ) { 
                             retval.type = DataType.INTEGER;
                             retval.value = sign * Integer.valueOf( (INTEGER365!=null?INTEGER365.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1713:6: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER366=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_num_scalar5194); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER366_tree = (CommonTree)adaptor.dupNode(LONGINTEGER366);


                    adaptor.addChild(root_0, LONGINTEGER366_tree);
                    }


                    if ( state.backtracking==0 ) { 
                             retval.type = DataType.LONG;
                             retval.value = sign * builder.parseLong( (LONGINTEGER366!=null?LONGINTEGER366.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1718:6: FLOATNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    FLOATNUMBER367=(CommonTree)match(input,FLOATNUMBER,FOLLOW_FLOATNUMBER_in_num_scalar5209); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOATNUMBER367_tree = (CommonTree)adaptor.dupNode(FLOATNUMBER367);


                    adaptor.addChild(root_0, FLOATNUMBER367_tree);
                    }


                    if ( state.backtracking==0 ) { 
                             retval.type = DataType.FLOAT;
                             retval.value = sign * Float.valueOf( (FLOATNUMBER367!=null?FLOATNUMBER367.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1723:6: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER368=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_num_scalar5224); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER368_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER368);


                    adaptor.addChild(root_0, DOUBLENUMBER368_tree);
                    }


                    if ( state.backtracking==0 ) { 
                             retval.type = DataType.DOUBLE;
                             retval.value = sign * Double.valueOf( (DOUBLENUMBER368!=null?DOUBLENUMBER368.getText():null) );
                         }

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
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1731:1: map returns [Object value] : ^( MAP_VAL ( keyvalue )* ) ;
    public final LogicalPlanGenerator.map_return map() throws RecognitionException {
        LogicalPlanGenerator.map_return retval = new LogicalPlanGenerator.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL369=null;
        LogicalPlanGenerator.keyvalue_return keyvalue370 =null;


        CommonTree MAP_VAL369_tree=null;

         Map<String, Object> kvs = new HashMap<String, Object>(); 
        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1733:2: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1733:4: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL369=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map5257); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL369_tree = (CommonTree)adaptor.dupNode(MAP_VAL369);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL369_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1733:15: ( keyvalue )*
                loop119:
                do {
                    int alt119=2;
                    int LA119_0 = input.LA(1);

                    if ( (LA119_0==KEY_VAL_PAIR) ) {
                        alt119=1;
                    }


                    switch (alt119) {
                	case 1 :
                	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1733:17: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map5261);
                	    keyvalue370=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue370.getTree());


                	    if ( state.backtracking==0 ) { kvs.put( (keyvalue370!=null?keyvalue370.key:null), (keyvalue370!=null?keyvalue370.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop119;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = kvs;
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
        public String key;
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1739:1: keyvalue returns [String key, Object value] : ^( KEY_VAL_PAIR map_key literal ) ;
    public final LogicalPlanGenerator.keyvalue_return keyvalue() throws RecognitionException {
        LogicalPlanGenerator.keyvalue_return retval = new LogicalPlanGenerator.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR371=null;
        LogicalPlanGenerator.map_key_return map_key372 =null;

        LogicalPlanGenerator.literal_return literal373 =null;


        CommonTree KEY_VAL_PAIR371_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1740:2: ( ^( KEY_VAL_PAIR map_key literal ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1740:4: ^( KEY_VAL_PAIR map_key literal )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR371=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue5288); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR371_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR371);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR371_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue5290);
            map_key372=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key372.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_keyvalue5292);
            literal373=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, literal373.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.key = (map_key372!=null?map_key372.value:null);
                   retval.value = (literal373!=null?literal373.value:null);
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
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_key"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1747:1: map_key returns [String value] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.map_key_return map_key() throws RecognitionException {
        LogicalPlanGenerator.map_key_return retval = new LogicalPlanGenerator.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING374=null;

        CommonTree QUOTEDSTRING374_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1748:2: ( QUOTEDSTRING )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1748:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING374=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key5312); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING374_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING374);


            adaptor.addChild(root_0, QUOTEDSTRING374_tree);
            }


            if ( state.backtracking==0 ) { retval.value = builder.unquote( (QUOTEDSTRING374!=null?QUOTEDSTRING374.getText():null) ); }

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
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1751:1: bag returns [Object value] : ^( BAG_VAL ( tuple )* ) ;
    public final LogicalPlanGenerator.bag_return bag() throws RecognitionException {
        LogicalPlanGenerator.bag_return retval = new LogicalPlanGenerator.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL375=null;
        LogicalPlanGenerator.tuple_return tuple376 =null;


        CommonTree BAG_VAL375_tree=null;

         DataBag dataBag = builder.createDataBag(); 
        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1753:2: ( ^( BAG_VAL ( tuple )* ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1753:4: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL375=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag5334); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL375_tree = (CommonTree)adaptor.dupNode(BAG_VAL375);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL375_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1753:15: ( tuple )*
                loop120:
                do {
                    int alt120=2;
                    int LA120_0 = input.LA(1);

                    if ( (LA120_0==TUPLE_VAL) ) {
                        alt120=1;
                    }


                    switch (alt120) {
                	case 1 :
                	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1753:17: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag5338);
                	    tuple376=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple376.getTree());


                	    if ( state.backtracking==0 ) { dataBag.add( (tuple376!=null?tuple376.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop120;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = dataBag;
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
        public Tuple value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1759:1: tuple returns [Tuple value] : ^( TUPLE_VAL ( literal )* ) ;
    public final LogicalPlanGenerator.tuple_return tuple() throws RecognitionException {
        LogicalPlanGenerator.tuple_return retval = new LogicalPlanGenerator.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL377=null;
        LogicalPlanGenerator.literal_return literal378 =null;


        CommonTree TUPLE_VAL377_tree=null;

         List<Object> objList = new ArrayList<Object>(); 
        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1761:2: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1761:4: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL377=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple5370); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL377_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL377);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL377_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1761:17: ( literal )*
                loop121:
                do {
                    int alt121=2;
                    int LA121_0 = input.LA(1);

                    if ( (LA121_0==DOUBLENUMBER||LA121_0==FALSE||LA121_0==FLOATNUMBER||LA121_0==INTEGER||LA121_0==LONGINTEGER||LA121_0==MINUS||LA121_0==QUOTEDSTRING||LA121_0==TRUE||LA121_0==BAG_VAL||LA121_0==MAP_VAL||LA121_0==NULL||LA121_0==TUPLE_VAL) ) {
                        alt121=1;
                    }


                    switch (alt121) {
                	case 1 :
                	    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1761:19: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple5374);
                	    literal378=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal378.getTree());


                	    if ( state.backtracking==0 ) { objList.add( (literal378!=null?literal378.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop121;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = builder.buildTuple( objList );
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
        public String id;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1768:1: eid returns [String id] : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | CUBE | ROLLUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE );
    public final LogicalPlanGenerator.eid_return eid() throws RecognitionException {
        LogicalPlanGenerator.eid_return retval = new LogicalPlanGenerator.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT380=null;
        CommonTree RETURNS381=null;
        CommonTree DEFINE382=null;
        CommonTree LOAD383=null;
        CommonTree FILTER384=null;
        CommonTree FOREACH385=null;
        CommonTree MATCHES386=null;
        CommonTree ORDER387=null;
        CommonTree DISTINCT388=null;
        CommonTree COGROUP389=null;
        CommonTree CUBE390=null;
        CommonTree ROLLUP391=null;
        CommonTree JOIN392=null;
        CommonTree CROSS393=null;
        CommonTree UNION394=null;
        CommonTree SPLIT395=null;
        CommonTree INTO396=null;
        CommonTree IF397=null;
        CommonTree ALL398=null;
        CommonTree AS399=null;
        CommonTree BY400=null;
        CommonTree USING401=null;
        CommonTree INNER402=null;
        CommonTree OUTER403=null;
        CommonTree PARALLEL404=null;
        CommonTree PARTITION405=null;
        CommonTree GROUP406=null;
        CommonTree AND407=null;
        CommonTree OR408=null;
        CommonTree NOT409=null;
        CommonTree GENERATE410=null;
        CommonTree FLATTEN411=null;
        CommonTree EVAL412=null;
        CommonTree ASC413=null;
        CommonTree DESC414=null;
        CommonTree BOOLEAN415=null;
        CommonTree INT416=null;
        CommonTree LONG417=null;
        CommonTree FLOAT418=null;
        CommonTree DOUBLE419=null;
        CommonTree DATETIME420=null;
        CommonTree CHARARRAY421=null;
        CommonTree BYTEARRAY422=null;
        CommonTree BAG423=null;
        CommonTree TUPLE424=null;
        CommonTree MAP425=null;
        CommonTree IS426=null;
        CommonTree NULL427=null;
        CommonTree TRUE428=null;
        CommonTree FALSE429=null;
        CommonTree STREAM430=null;
        CommonTree THROUGH431=null;
        CommonTree STORE432=null;
        CommonTree MAPREDUCE433=null;
        CommonTree SHIP434=null;
        CommonTree CACHE435=null;
        CommonTree INPUT436=null;
        CommonTree OUTPUT437=null;
        CommonTree STDERROR438=null;
        CommonTree STDIN439=null;
        CommonTree STDOUT440=null;
        CommonTree LIMIT441=null;
        CommonTree SAMPLE442=null;
        CommonTree LEFT443=null;
        CommonTree RIGHT444=null;
        CommonTree FULL445=null;
        CommonTree IDENTIFIER446=null;
        CommonTree TOBAG447=null;
        CommonTree TOMAP448=null;
        CommonTree TOTUPLE449=null;
        LogicalPlanGenerator.rel_str_op_return rel_str_op379 =null;


        CommonTree IMPORT380_tree=null;
        CommonTree RETURNS381_tree=null;
        CommonTree DEFINE382_tree=null;
        CommonTree LOAD383_tree=null;
        CommonTree FILTER384_tree=null;
        CommonTree FOREACH385_tree=null;
        CommonTree MATCHES386_tree=null;
        CommonTree ORDER387_tree=null;
        CommonTree DISTINCT388_tree=null;
        CommonTree COGROUP389_tree=null;
        CommonTree CUBE390_tree=null;
        CommonTree ROLLUP391_tree=null;
        CommonTree JOIN392_tree=null;
        CommonTree CROSS393_tree=null;
        CommonTree UNION394_tree=null;
        CommonTree SPLIT395_tree=null;
        CommonTree INTO396_tree=null;
        CommonTree IF397_tree=null;
        CommonTree ALL398_tree=null;
        CommonTree AS399_tree=null;
        CommonTree BY400_tree=null;
        CommonTree USING401_tree=null;
        CommonTree INNER402_tree=null;
        CommonTree OUTER403_tree=null;
        CommonTree PARALLEL404_tree=null;
        CommonTree PARTITION405_tree=null;
        CommonTree GROUP406_tree=null;
        CommonTree AND407_tree=null;
        CommonTree OR408_tree=null;
        CommonTree NOT409_tree=null;
        CommonTree GENERATE410_tree=null;
        CommonTree FLATTEN411_tree=null;
        CommonTree EVAL412_tree=null;
        CommonTree ASC413_tree=null;
        CommonTree DESC414_tree=null;
        CommonTree BOOLEAN415_tree=null;
        CommonTree INT416_tree=null;
        CommonTree LONG417_tree=null;
        CommonTree FLOAT418_tree=null;
        CommonTree DOUBLE419_tree=null;
        CommonTree DATETIME420_tree=null;
        CommonTree CHARARRAY421_tree=null;
        CommonTree BYTEARRAY422_tree=null;
        CommonTree BAG423_tree=null;
        CommonTree TUPLE424_tree=null;
        CommonTree MAP425_tree=null;
        CommonTree IS426_tree=null;
        CommonTree NULL427_tree=null;
        CommonTree TRUE428_tree=null;
        CommonTree FALSE429_tree=null;
        CommonTree STREAM430_tree=null;
        CommonTree THROUGH431_tree=null;
        CommonTree STORE432_tree=null;
        CommonTree MAPREDUCE433_tree=null;
        CommonTree SHIP434_tree=null;
        CommonTree CACHE435_tree=null;
        CommonTree INPUT436_tree=null;
        CommonTree OUTPUT437_tree=null;
        CommonTree STDERROR438_tree=null;
        CommonTree STDIN439_tree=null;
        CommonTree STDOUT440_tree=null;
        CommonTree LIMIT441_tree=null;
        CommonTree SAMPLE442_tree=null;
        CommonTree LEFT443_tree=null;
        CommonTree RIGHT444_tree=null;
        CommonTree FULL445_tree=null;
        CommonTree IDENTIFIER446_tree=null;
        CommonTree TOBAG447_tree=null;
        CommonTree TOMAP448_tree=null;
        CommonTree TOTUPLE449_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1768:24: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | CUBE | ROLLUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE )
            int alt122=71;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt122=1;
                }
                break;
            case IMPORT:
                {
                alt122=2;
                }
                break;
            case RETURNS:
                {
                alt122=3;
                }
                break;
            case DEFINE:
                {
                alt122=4;
                }
                break;
            case LOAD:
                {
                alt122=5;
                }
                break;
            case FILTER:
                {
                alt122=6;
                }
                break;
            case FOREACH:
                {
                alt122=7;
                }
                break;
            case MATCHES:
                {
                alt122=8;
                }
                break;
            case ORDER:
                {
                alt122=9;
                }
                break;
            case DISTINCT:
                {
                alt122=10;
                }
                break;
            case COGROUP:
                {
                alt122=11;
                }
                break;
            case CUBE:
                {
                alt122=12;
                }
                break;
            case ROLLUP:
                {
                alt122=13;
                }
                break;
            case JOIN:
                {
                alt122=14;
                }
                break;
            case CROSS:
                {
                alt122=15;
                }
                break;
            case UNION:
                {
                alt122=16;
                }
                break;
            case SPLIT:
                {
                alt122=17;
                }
                break;
            case INTO:
                {
                alt122=18;
                }
                break;
            case IF:
                {
                alt122=19;
                }
                break;
            case ALL:
                {
                alt122=20;
                }
                break;
            case AS:
                {
                alt122=21;
                }
                break;
            case BY:
                {
                alt122=22;
                }
                break;
            case USING:
                {
                alt122=23;
                }
                break;
            case INNER:
                {
                alt122=24;
                }
                break;
            case OUTER:
                {
                alt122=25;
                }
                break;
            case PARALLEL:
                {
                alt122=26;
                }
                break;
            case PARTITION:
                {
                alt122=27;
                }
                break;
            case GROUP:
                {
                alt122=28;
                }
                break;
            case AND:
                {
                alt122=29;
                }
                break;
            case OR:
                {
                alt122=30;
                }
                break;
            case NOT:
                {
                alt122=31;
                }
                break;
            case GENERATE:
                {
                alt122=32;
                }
                break;
            case FLATTEN:
                {
                alt122=33;
                }
                break;
            case EVAL:
                {
                alt122=34;
                }
                break;
            case ASC:
                {
                alt122=35;
                }
                break;
            case DESC:
                {
                alt122=36;
                }
                break;
            case BOOLEAN:
                {
                alt122=37;
                }
                break;
            case INT:
                {
                alt122=38;
                }
                break;
            case LONG:
                {
                alt122=39;
                }
                break;
            case FLOAT:
                {
                alt122=40;
                }
                break;
            case DOUBLE:
                {
                alt122=41;
                }
                break;
            case DATETIME:
                {
                alt122=42;
                }
                break;
            case CHARARRAY:
                {
                alt122=43;
                }
                break;
            case BYTEARRAY:
                {
                alt122=44;
                }
                break;
            case BAG:
                {
                alt122=45;
                }
                break;
            case TUPLE:
                {
                alt122=46;
                }
                break;
            case MAP:
                {
                alt122=47;
                }
                break;
            case IS:
                {
                alt122=48;
                }
                break;
            case NULL:
                {
                alt122=49;
                }
                break;
            case TRUE:
                {
                alt122=50;
                }
                break;
            case FALSE:
                {
                alt122=51;
                }
                break;
            case STREAM:
                {
                alt122=52;
                }
                break;
            case THROUGH:
                {
                alt122=53;
                }
                break;
            case STORE:
                {
                alt122=54;
                }
                break;
            case MAPREDUCE:
                {
                alt122=55;
                }
                break;
            case SHIP:
                {
                alt122=56;
                }
                break;
            case CACHE:
                {
                alt122=57;
                }
                break;
            case INPUT:
                {
                alt122=58;
                }
                break;
            case OUTPUT:
                {
                alt122=59;
                }
                break;
            case STDERROR:
                {
                alt122=60;
                }
                break;
            case STDIN:
                {
                alt122=61;
                }
                break;
            case STDOUT:
                {
                alt122=62;
                }
                break;
            case LIMIT:
                {
                alt122=63;
                }
                break;
            case SAMPLE:
                {
                alt122=64;
                }
                break;
            case LEFT:
                {
                alt122=65;
                }
                break;
            case RIGHT:
                {
                alt122=66;
                }
                break;
            case FULL:
                {
                alt122=67;
                }
                break;
            case IDENTIFIER:
                {
                alt122=68;
                }
                break;
            case TOBAG:
                {
                alt122=69;
                }
                break;
            case TOMAP:
                {
                alt122=70;
                }
                break;
            case TOTUPLE:
                {
                alt122=71;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;

            }

            switch (alt122) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1768:26: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid5399);
                    rel_str_op379=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op379.getTree());


                    if ( state.backtracking==0 ) { retval.id = (rel_str_op379!=null?rel_str_op379.id:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1769:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT380=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid5409); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT380_tree = (CommonTree)adaptor.dupNode(IMPORT380);


                    adaptor.addChild(root_0, IMPORT380_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IMPORT380!=null?IMPORT380.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1770:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS381=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid5419); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS381_tree = (CommonTree)adaptor.dupNode(RETURNS381);


                    adaptor.addChild(root_0, RETURNS381_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (RETURNS381!=null?RETURNS381.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1771:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE382=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid5429); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE382_tree = (CommonTree)adaptor.dupNode(DEFINE382);


                    adaptor.addChild(root_0, DEFINE382_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DEFINE382!=null?DEFINE382.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1772:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD383=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid5439); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD383_tree = (CommonTree)adaptor.dupNode(LOAD383);


                    adaptor.addChild(root_0, LOAD383_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LOAD383!=null?LOAD383.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1773:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER384=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid5449); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER384_tree = (CommonTree)adaptor.dupNode(FILTER384);


                    adaptor.addChild(root_0, FILTER384_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FILTER384!=null?FILTER384.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1774:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH385=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid5459); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH385_tree = (CommonTree)adaptor.dupNode(FOREACH385);


                    adaptor.addChild(root_0, FOREACH385_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FOREACH385!=null?FOREACH385.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1775:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES386=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid5469); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES386_tree = (CommonTree)adaptor.dupNode(MATCHES386);


                    adaptor.addChild(root_0, MATCHES386_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MATCHES386!=null?MATCHES386.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1776:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER387=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid5479); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER387_tree = (CommonTree)adaptor.dupNode(ORDER387);


                    adaptor.addChild(root_0, ORDER387_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ORDER387!=null?ORDER387.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1777:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT388=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid5489); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT388_tree = (CommonTree)adaptor.dupNode(DISTINCT388);


                    adaptor.addChild(root_0, DISTINCT388_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DISTINCT388!=null?DISTINCT388.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1778:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP389=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid5499); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP389_tree = (CommonTree)adaptor.dupNode(COGROUP389);


                    adaptor.addChild(root_0, COGROUP389_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (COGROUP389!=null?COGROUP389.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1779:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE390=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid5509); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE390_tree = (CommonTree)adaptor.dupNode(CUBE390);


                    adaptor.addChild(root_0, CUBE390_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CUBE390!=null?CUBE390.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1780:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP391=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid5519); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP391_tree = (CommonTree)adaptor.dupNode(ROLLUP391);


                    adaptor.addChild(root_0, ROLLUP391_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ROLLUP391!=null?ROLLUP391.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1781:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN392=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid5529); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN392_tree = (CommonTree)adaptor.dupNode(JOIN392);


                    adaptor.addChild(root_0, JOIN392_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (JOIN392!=null?JOIN392.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1782:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS393=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid5539); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS393_tree = (CommonTree)adaptor.dupNode(CROSS393);


                    adaptor.addChild(root_0, CROSS393_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CROSS393!=null?CROSS393.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1783:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION394=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid5549); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION394_tree = (CommonTree)adaptor.dupNode(UNION394);


                    adaptor.addChild(root_0, UNION394_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (UNION394!=null?UNION394.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1784:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT395=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid5559); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT395_tree = (CommonTree)adaptor.dupNode(SPLIT395);


                    adaptor.addChild(root_0, SPLIT395_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SPLIT395!=null?SPLIT395.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1785:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO396=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid5569); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO396_tree = (CommonTree)adaptor.dupNode(INTO396);


                    adaptor.addChild(root_0, INTO396_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INTO396!=null?INTO396.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1786:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF397=(CommonTree)match(input,IF,FOLLOW_IF_in_eid5579); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF397_tree = (CommonTree)adaptor.dupNode(IF397);


                    adaptor.addChild(root_0, IF397_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IF397!=null?IF397.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1787:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL398=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid5589); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL398_tree = (CommonTree)adaptor.dupNode(ALL398);


                    adaptor.addChild(root_0, ALL398_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ALL398!=null?ALL398.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1788:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS399=(CommonTree)match(input,AS,FOLLOW_AS_in_eid5599); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS399_tree = (CommonTree)adaptor.dupNode(AS399);


                    adaptor.addChild(root_0, AS399_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (AS399!=null?AS399.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1789:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY400=(CommonTree)match(input,BY,FOLLOW_BY_in_eid5609); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY400_tree = (CommonTree)adaptor.dupNode(BY400);


                    adaptor.addChild(root_0, BY400_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BY400!=null?BY400.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1790:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING401=(CommonTree)match(input,USING,FOLLOW_USING_in_eid5619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING401_tree = (CommonTree)adaptor.dupNode(USING401);


                    adaptor.addChild(root_0, USING401_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (USING401!=null?USING401.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1791:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER402=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid5629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER402_tree = (CommonTree)adaptor.dupNode(INNER402);


                    adaptor.addChild(root_0, INNER402_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INNER402!=null?INNER402.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1792:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER403=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid5639); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER403_tree = (CommonTree)adaptor.dupNode(OUTER403);


                    adaptor.addChild(root_0, OUTER403_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OUTER403!=null?OUTER403.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1793:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL404=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid5649); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL404_tree = (CommonTree)adaptor.dupNode(PARALLEL404);


                    adaptor.addChild(root_0, PARALLEL404_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PARALLEL404!=null?PARALLEL404.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1794:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION405=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid5659); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION405_tree = (CommonTree)adaptor.dupNode(PARTITION405);


                    adaptor.addChild(root_0, PARTITION405_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PARTITION405!=null?PARTITION405.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1795:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP406=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid5669); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP406_tree = (CommonTree)adaptor.dupNode(GROUP406);


                    adaptor.addChild(root_0, GROUP406_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (GROUP406!=null?GROUP406.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1796:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND407=(CommonTree)match(input,AND,FOLLOW_AND_in_eid5679); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND407_tree = (CommonTree)adaptor.dupNode(AND407);


                    adaptor.addChild(root_0, AND407_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (AND407!=null?AND407.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1797:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR408=(CommonTree)match(input,OR,FOLLOW_OR_in_eid5689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR408_tree = (CommonTree)adaptor.dupNode(OR408);


                    adaptor.addChild(root_0, OR408_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OR408!=null?OR408.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1798:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT409=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid5699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT409_tree = (CommonTree)adaptor.dupNode(NOT409);


                    adaptor.addChild(root_0, NOT409_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (NOT409!=null?NOT409.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1799:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE410=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid5709); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE410_tree = (CommonTree)adaptor.dupNode(GENERATE410);


                    adaptor.addChild(root_0, GENERATE410_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (GENERATE410!=null?GENERATE410.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1800:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN411=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid5719); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN411_tree = (CommonTree)adaptor.dupNode(FLATTEN411);


                    adaptor.addChild(root_0, FLATTEN411_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FLATTEN411!=null?FLATTEN411.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1801:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL412=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid5729); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL412_tree = (CommonTree)adaptor.dupNode(EVAL412);


                    adaptor.addChild(root_0, EVAL412_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (EVAL412!=null?EVAL412.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1802:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC413=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid5739); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC413_tree = (CommonTree)adaptor.dupNode(ASC413);


                    adaptor.addChild(root_0, ASC413_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ASC413!=null?ASC413.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1803:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC414=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid5749); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC414_tree = (CommonTree)adaptor.dupNode(DESC414);


                    adaptor.addChild(root_0, DESC414_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DESC414!=null?DESC414.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1804:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN415=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid5759); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN415_tree = (CommonTree)adaptor.dupNode(BOOLEAN415);


                    adaptor.addChild(root_0, BOOLEAN415_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BOOLEAN415!=null?BOOLEAN415.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1805:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT416=(CommonTree)match(input,INT,FOLLOW_INT_in_eid5769); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT416_tree = (CommonTree)adaptor.dupNode(INT416);


                    adaptor.addChild(root_0, INT416_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INT416!=null?INT416.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1806:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG417=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid5779); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG417_tree = (CommonTree)adaptor.dupNode(LONG417);


                    adaptor.addChild(root_0, LONG417_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LONG417!=null?LONG417.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1807:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT418=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid5789); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT418_tree = (CommonTree)adaptor.dupNode(FLOAT418);


                    adaptor.addChild(root_0, FLOAT418_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FLOAT418!=null?FLOAT418.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1808:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE419=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid5799); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE419_tree = (CommonTree)adaptor.dupNode(DOUBLE419);


                    adaptor.addChild(root_0, DOUBLE419_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DOUBLE419!=null?DOUBLE419.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1809:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME420=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid5809); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME420_tree = (CommonTree)adaptor.dupNode(DATETIME420);


                    adaptor.addChild(root_0, DATETIME420_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DATETIME420!=null?DATETIME420.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1810:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY421=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid5819); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY421_tree = (CommonTree)adaptor.dupNode(CHARARRAY421);


                    adaptor.addChild(root_0, CHARARRAY421_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CHARARRAY421!=null?CHARARRAY421.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1811:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY422=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid5829); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY422_tree = (CommonTree)adaptor.dupNode(BYTEARRAY422);


                    adaptor.addChild(root_0, BYTEARRAY422_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BYTEARRAY422!=null?BYTEARRAY422.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1812:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG423=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid5839); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG423_tree = (CommonTree)adaptor.dupNode(BAG423);


                    adaptor.addChild(root_0, BAG423_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BAG423!=null?BAG423.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1813:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE424=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid5849); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE424_tree = (CommonTree)adaptor.dupNode(TUPLE424);


                    adaptor.addChild(root_0, TUPLE424_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (TUPLE424!=null?TUPLE424.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1814:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP425=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid5859); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP425_tree = (CommonTree)adaptor.dupNode(MAP425);


                    adaptor.addChild(root_0, MAP425_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MAP425!=null?MAP425.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1815:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS426=(CommonTree)match(input,IS,FOLLOW_IS_in_eid5869); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS426_tree = (CommonTree)adaptor.dupNode(IS426);


                    adaptor.addChild(root_0, IS426_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IS426!=null?IS426.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1816:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL427=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid5879); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL427_tree = (CommonTree)adaptor.dupNode(NULL427);


                    adaptor.addChild(root_0, NULL427_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (NULL427!=null?NULL427.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1817:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE428=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid5889); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE428_tree = (CommonTree)adaptor.dupNode(TRUE428);


                    adaptor.addChild(root_0, TRUE428_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (TRUE428!=null?TRUE428.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1818:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE429=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid5899); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE429_tree = (CommonTree)adaptor.dupNode(FALSE429);


                    adaptor.addChild(root_0, FALSE429_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FALSE429!=null?FALSE429.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1819:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM430=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid5909); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM430_tree = (CommonTree)adaptor.dupNode(STREAM430);


                    adaptor.addChild(root_0, STREAM430_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STREAM430!=null?STREAM430.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1820:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH431=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid5919); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH431_tree = (CommonTree)adaptor.dupNode(THROUGH431);


                    adaptor.addChild(root_0, THROUGH431_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (THROUGH431!=null?THROUGH431.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1821:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE432=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid5929); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE432_tree = (CommonTree)adaptor.dupNode(STORE432);


                    adaptor.addChild(root_0, STORE432_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STORE432!=null?STORE432.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1822:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE433=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid5939); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE433_tree = (CommonTree)adaptor.dupNode(MAPREDUCE433);


                    adaptor.addChild(root_0, MAPREDUCE433_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MAPREDUCE433!=null?MAPREDUCE433.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1823:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP434=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid5949); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP434_tree = (CommonTree)adaptor.dupNode(SHIP434);


                    adaptor.addChild(root_0, SHIP434_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SHIP434!=null?SHIP434.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1824:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE435=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid5959); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE435_tree = (CommonTree)adaptor.dupNode(CACHE435);


                    adaptor.addChild(root_0, CACHE435_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CACHE435!=null?CACHE435.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1825:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT436=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid5969); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT436_tree = (CommonTree)adaptor.dupNode(INPUT436);


                    adaptor.addChild(root_0, INPUT436_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INPUT436!=null?INPUT436.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1826:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT437=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid5979); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT437_tree = (CommonTree)adaptor.dupNode(OUTPUT437);


                    adaptor.addChild(root_0, OUTPUT437_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OUTPUT437!=null?OUTPUT437.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1827:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR438=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid5989); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR438_tree = (CommonTree)adaptor.dupNode(STDERROR438);


                    adaptor.addChild(root_0, STDERROR438_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDERROR438!=null?STDERROR438.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1828:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN439=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid5999); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN439_tree = (CommonTree)adaptor.dupNode(STDIN439);


                    adaptor.addChild(root_0, STDIN439_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDIN439!=null?STDIN439.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1829:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT440=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid6009); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT440_tree = (CommonTree)adaptor.dupNode(STDOUT440);


                    adaptor.addChild(root_0, STDOUT440_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDOUT440!=null?STDOUT440.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1830:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT441=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid6019); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT441_tree = (CommonTree)adaptor.dupNode(LIMIT441);


                    adaptor.addChild(root_0, LIMIT441_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LIMIT441!=null?LIMIT441.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1831:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE442=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid6029); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE442_tree = (CommonTree)adaptor.dupNode(SAMPLE442);


                    adaptor.addChild(root_0, SAMPLE442_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SAMPLE442!=null?SAMPLE442.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1832:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT443=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid6039); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT443_tree = (CommonTree)adaptor.dupNode(LEFT443);


                    adaptor.addChild(root_0, LEFT443_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LEFT443!=null?LEFT443.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1833:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT444=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid6049); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT444_tree = (CommonTree)adaptor.dupNode(RIGHT444);


                    adaptor.addChild(root_0, RIGHT444_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (RIGHT444!=null?RIGHT444.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1834:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL445=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid6059); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL445_tree = (CommonTree)adaptor.dupNode(FULL445);


                    adaptor.addChild(root_0, FULL445_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FULL445!=null?FULL445.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1835:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER446=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid6069); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER446_tree = (CommonTree)adaptor.dupNode(IDENTIFIER446);


                    adaptor.addChild(root_0, IDENTIFIER446_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IDENTIFIER446!=null?IDENTIFIER446.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1836:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG447=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid6079); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG447_tree = (CommonTree)adaptor.dupNode(TOBAG447);


                    adaptor.addChild(root_0, TOBAG447_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOBAG"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1837:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP448=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid6089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP448_tree = (CommonTree)adaptor.dupNode(TOMAP448);


                    adaptor.addChild(root_0, TOMAP448_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOMAP"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1838:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE449=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid6099); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE449_tree = (CommonTree)adaptor.dupNode(TOTUPLE449);


                    adaptor.addChild(root_0, TOTUPLE449_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOTUPLE"; }

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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1842:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final LogicalPlanGenerator.rel_op_return rel_op() throws RecognitionException {
        LogicalPlanGenerator.rel_op_return retval = new LogicalPlanGenerator.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES456=null;
        LogicalPlanGenerator.rel_op_eq_return rel_op_eq450 =null;

        LogicalPlanGenerator.rel_op_ne_return rel_op_ne451 =null;

        LogicalPlanGenerator.rel_op_gt_return rel_op_gt452 =null;

        LogicalPlanGenerator.rel_op_gte_return rel_op_gte453 =null;

        LogicalPlanGenerator.rel_op_lt_return rel_op_lt454 =null;

        LogicalPlanGenerator.rel_op_lte_return rel_op_lte455 =null;


        CommonTree STR_OP_MATCHES456_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1842:8: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt123=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt123=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt123=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt123=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt123=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt123=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt123=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt123=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;

            }

            switch (alt123) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1842:10: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op6111);
                    rel_op_eq450=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq450.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1843:10: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op6122);
                    rel_op_ne451=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne451.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1844:10: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op6133);
                    rel_op_gt452=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt452.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1845:10: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op6144);
                    rel_op_gte453=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte453.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1846:10: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op6155);
                    rel_op_lt454=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt454.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1847:10: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op6166);
                    rel_op_lte455=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte455.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1848:10: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES456=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op6177); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES456_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES456);


                    adaptor.addChild(root_0, STR_OP_MATCHES456_tree);
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1851:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final LogicalPlanGenerator.rel_op_eq_return rel_op_eq() throws RecognitionException {
        LogicalPlanGenerator.rel_op_eq_return retval = new LogicalPlanGenerator.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set457=null;

        CommonTree set457_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1851:11: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set457=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
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
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1854:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final LogicalPlanGenerator.rel_op_ne_return rel_op_ne() throws RecognitionException {
        LogicalPlanGenerator.rel_op_ne_return retval = new LogicalPlanGenerator.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set458=null;

        CommonTree set458_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1854:11: ( STR_OP_NE | NUM_OP_NE )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set458=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
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
    // $ANTLR end "rel_op_ne"


    public static class rel_op_gt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gt"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1857:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final LogicalPlanGenerator.rel_op_gt_return rel_op_gt() throws RecognitionException {
        LogicalPlanGenerator.rel_op_gt_return retval = new LogicalPlanGenerator.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set459=null;

        CommonTree set459_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1857:11: ( STR_OP_GT | NUM_OP_GT )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set459=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set459_tree = (CommonTree)adaptor.dupNode(set459);


                adaptor.addChild(root_0, set459_tree);
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1860:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final LogicalPlanGenerator.rel_op_gte_return rel_op_gte() throws RecognitionException {
        LogicalPlanGenerator.rel_op_gte_return retval = new LogicalPlanGenerator.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set460=null;

        CommonTree set460_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1860:12: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set460=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set460_tree = (CommonTree)adaptor.dupNode(set460);


                adaptor.addChild(root_0, set460_tree);
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1863:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final LogicalPlanGenerator.rel_op_lt_return rel_op_lt() throws RecognitionException {
        LogicalPlanGenerator.rel_op_lt_return retval = new LogicalPlanGenerator.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set461=null;

        CommonTree set461_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1863:11: ( STR_OP_LT | NUM_OP_LT )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set461=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set461_tree = (CommonTree)adaptor.dupNode(set461);


                adaptor.addChild(root_0, set461_tree);
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
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1866:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final LogicalPlanGenerator.rel_op_lte_return rel_op_lte() throws RecognitionException {
        LogicalPlanGenerator.rel_op_lte_return retval = new LogicalPlanGenerator.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set462=null;

        CommonTree set462_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1866:12: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set462=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set462_tree = (CommonTree)adaptor.dupNode(set462);


                adaptor.addChild(root_0, set462_tree);
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
        public String id;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1869:1: rel_str_op returns [String id] : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final LogicalPlanGenerator.rel_str_op_return rel_str_op() throws RecognitionException {
        LogicalPlanGenerator.rel_str_op_return retval = new LogicalPlanGenerator.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ463=null;
        CommonTree STR_OP_NE464=null;
        CommonTree STR_OP_GT465=null;
        CommonTree STR_OP_LT466=null;
        CommonTree STR_OP_GTE467=null;
        CommonTree STR_OP_LTE468=null;
        CommonTree STR_OP_MATCHES469=null;

        CommonTree STR_OP_EQ463_tree=null;
        CommonTree STR_OP_NE464_tree=null;
        CommonTree STR_OP_GT465_tree=null;
        CommonTree STR_OP_LT466_tree=null;
        CommonTree STR_OP_GTE467_tree=null;
        CommonTree STR_OP_LTE468_tree=null;
        CommonTree STR_OP_MATCHES469_tree=null;

        try {
            // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1870:2: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            int alt124=7;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
                {
                alt124=1;
                }
                break;
            case STR_OP_NE:
                {
                alt124=2;
                }
                break;
            case STR_OP_GT:
                {
                alt124=3;
                }
                break;
            case STR_OP_LT:
                {
                alt124=4;
                }
                break;
            case STR_OP_GTE:
                {
                alt124=5;
                }
                break;
            case STR_OP_LTE:
                {
                alt124=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt124=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;

            }

            switch (alt124) {
                case 1 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1870:4: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ463=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_str_op6268); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ463_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ463);


                    adaptor.addChild(root_0, STR_OP_EQ463_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_EQ463!=null?STR_OP_EQ463.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1871:4: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE464=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_str_op6275); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE464_tree = (CommonTree)adaptor.dupNode(STR_OP_NE464);


                    adaptor.addChild(root_0, STR_OP_NE464_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_NE464!=null?STR_OP_NE464.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1872:4: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT465=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_str_op6282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT465_tree = (CommonTree)adaptor.dupNode(STR_OP_GT465);


                    adaptor.addChild(root_0, STR_OP_GT465_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_GT465!=null?STR_OP_GT465.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1873:4: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT466=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_str_op6289); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT466_tree = (CommonTree)adaptor.dupNode(STR_OP_LT466);


                    adaptor.addChild(root_0, STR_OP_LT466_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_LT466!=null?STR_OP_LT466.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1874:4: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE467=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_str_op6296); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE467_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE467);


                    adaptor.addChild(root_0, STR_OP_GTE467_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_GTE467!=null?STR_OP_GTE467.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1875:4: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE468=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_str_op6303); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE468_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE468);


                    adaptor.addChild(root_0, STR_OP_LTE468_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_LTE468!=null?STR_OP_LTE468.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1876:4: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES469=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_str_op6310); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES469_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES469);


                    adaptor.addChild(root_0, STR_OP_MATCHES469_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_MATCHES469!=null?STR_OP_MATCHES469.getText():null); }

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
    // $ANTLR end "rel_str_op"

    // $ANTLR start synpred128_LogicalPlanGenerator
    public final void synpred128_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1019:20: ( INTEGER )
        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1019:20: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred128_LogicalPlanGenerator3208); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred128_LogicalPlanGenerator

    // $ANTLR start synpred129_LogicalPlanGenerator
    public final void synpred129_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1024:4: ( LONGINTEGER )
        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1024:4: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred129_LogicalPlanGenerator3218); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred129_LogicalPlanGenerator

    // $ANTLR start synpred130_LogicalPlanGenerator
    public final void synpred130_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1043:20: ( DOUBLENUMBER )
        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1043:20: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred130_LogicalPlanGenerator3270); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred130_LogicalPlanGenerator

    // $ANTLR start synpred160_LogicalPlanGenerator
    public final void synpred160_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1232:4: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1232:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred160_LogicalPlanGenerator3807);
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


        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1237:66: ( OUTER )?
        int alt137=2;
        int LA137_0 = input.LA(1);

        if ( (LA137_0==OUTER) ) {
            alt137=1;
        }
        switch (alt137) {
            case 1 :
                // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1237:66: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred160_LogicalPlanGenerator3856); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred160_LogicalPlanGenerator3859);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred160_LogicalPlanGenerator

    // $ANTLR start synpred177_LogicalPlanGenerator
    public final void synpred177_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1421:31: ( INTEGER )
        // /home/iman/workspace/reStoreV3/src/org/apache/pig/parser/LogicalPlanGenerator.g:1421:31: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred177_LogicalPlanGenerator4433); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred177_LogicalPlanGenerator

    // Delegated rules

    public final boolean synpred128_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred160_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred160_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred177_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred177_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred130_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred130_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred129_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred129_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_QUERY_in_query88 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query90 = new BitSet(new long[]{0x0000000000000008L,0x0000004000000000L,0x0000000048000000L});
    public static final BitSet FOLLOW_general_statement_in_statement112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement152 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement156 = new BitSet(new long[]{0x3040090802264000L,0x0080180204004002L});
    public static final BitSet FOLLOW_op_clause_in_general_statement167 = new BitSet(new long[]{0x0000000000000008L,0x0000000000040000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement169 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause186 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause188 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause190 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause209 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause211 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause526 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause528 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause530 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause546 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause548 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_func_clause_in_define_clause550 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd579 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd583 = new BitSet(new long[]{0x0002000000001008L,0x0000010800020000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd588 = new BitSet(new long[]{0x0002000000001008L,0x0000010800020000L});
    public static final BitSet FOLLOW_input_clause_in_cmd593 = new BitSet(new long[]{0x0002000000001008L,0x0000010800020000L});
    public static final BitSet FOLLOW_output_clause_in_cmd597 = new BitSet(new long[]{0x0002000000001008L,0x0000010800020000L});
    public static final BitSet FOLLOW_error_clause_in_cmd601 = new BitSet(new long[]{0x0002000000001008L,0x0000010800020000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause624 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause626 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list643 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause661 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause663 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause686 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause690 = new BitSet(new long[]{0x0000000000000008L,0x0000060002000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd724 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd736 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd751 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd763 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd778 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd790 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause818 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause822 = new BitSet(new long[]{0x0000000000000008L,0x0000060002000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause850 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause861 = new BitSet(new long[]{0x0008000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause884 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause938 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause940 = new BitSet(new long[]{0x0000000000000048L,0x0000000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_func_clause_in_load_clause942 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_as_clause_in_load_clause946 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause983 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause985 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def1014 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def1016 = new BitSet(new long[]{0x4004002020082A08L,0x1000000000000000L,0x0000000400040000L});
    public static final BitSet FOLLOW_type_in_field_def1020 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def1039 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def1043 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list1074 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_simple_type_in_type1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_simple_type1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1208 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1219 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1259 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1261 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1264 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1287 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1289 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1320 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1334 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1336 = new BitSet(new long[]{0x0000000000000008L,0x0000000002000010L});
    public static final BitSet FOLLOW_func_args_in_func_clause1338 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1369 = new BitSet(new long[]{0x0000000008000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_PERIOD_in_func_name1383 = new BitSet(new long[]{0x70F7CF3C22AE7FF0L,0x01FFFF4B180F6023L,0x0000006381001000L});
    public static final BitSet FOLLOW_DOLLAR_in_func_name1389 = new BitSet(new long[]{0x70F7CF3C22AE7FF0L,0x01FFFF4B180F6023L,0x0000006381001000L});
    public static final BitSet FOLLOW_eid_in_func_name1405 = new BitSet(new long[]{0x0000000008000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1434 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000010L});
    public static final BitSet FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1445 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000010L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1487 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1489 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1506 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1538 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1540 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1563 = new BitSet(new long[]{0x0000000000040002L,0x0000000100000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_rollup_list1594 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ROLLUP_in_cube_rollup_list1600 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1606 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1631 = new BitSet(new long[]{0x8008088454040002L,0xC020008002500004L,0x000000100118141CL});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_group_clause1706 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1708 = new BitSet(new long[]{0x3040090802264008L,0x0080180206084002L,0x0000000000001000L});
    public static final BitSet FOLLOW_group_type_in_group_clause1713 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1720 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COGROUP_in_group_clause1735 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1737 = new BitSet(new long[]{0x3040090802264008L,0x0080180206084002L,0x0000000000001000L});
    public static final BitSet FOLLOW_group_type_in_group_clause1742 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1749 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1791 = new BitSet(new long[]{0x0000000000000410L,0x0800000000000000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1795 = new BitSet(new long[]{0x0001000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_ALL_in_group_item1820 = new BitSet(new long[]{0x0001000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_ANY_in_group_item1845 = new BitSet(new long[]{0x0001000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_INNER_in_group_item1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_group_item1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_rel1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inline_op_in_rel1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_inline_op1924 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_parallel_clause_in_inline_op1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1952 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1962 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1970 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1978 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause2015 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause2017 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause2035 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause2037 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_filename_in_store_clause2039 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_func_clause_in_store_clause2041 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause2075 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause2077 = new BitSet(new long[]{0x0000000000000020L,0x000FE00000002FE0L,0x0000000001000402L});
    public static final BitSet FOLLOW_cond_in_filter_clause2079 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond2103 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2109 = new BitSet(new long[]{0x0000000000000020L,0x000FE00000002FE0L,0x0000000001000402L});
    public static final BitSet FOLLOW_cond_in_cond2116 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond2131 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2137 = new BitSet(new long[]{0x0000000000000020L,0x000FE00000002FE0L,0x0000000001000402L});
    public static final BitSet FOLLOW_cond_in_cond2144 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond2159 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2165 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond2180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2182 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000020L});
    public static final BitSet FOLLOW_NOT_in_cond2185 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_eq_in_cond2200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2206 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_cond2213 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_ne_in_cond2229 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2235 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_cond2242 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_lt_in_cond2258 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2264 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_cond2271 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_lte_in_cond2287 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2293 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_cond2300 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_gt_in_cond2315 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2321 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_cond2328 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_gte_in_cond2344 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2350 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_cond2357 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_cond2372 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2378 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_cond2385 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_eval_in_cond2398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond2411 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2417 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval2450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval2452 = new BitSet(new long[]{0x8008088454040008L,0xC020008002500004L,0x000000100118141CL});
    public static final BitSet FOLLOW_real_arg_in_func_eval2456 = new BitSet(new long[]{0x8008088454040008L,0xC020008002500004L,0x000000100118141CL});
    public static final BitSet FOLLOW_expr_in_real_arg2488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg2496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr2529 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2535 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_expr2542 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr2557 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2563 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_expr2570 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr2585 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2591 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_expr2598 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr2613 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2619 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_expr2626 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr2641 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2647 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_expr2654 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr2667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr2678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr2691 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2697 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr2712 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr2714 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_expr2720 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr2736 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2742 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast2764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast2784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast2794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2819 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2823 = new BitSet(new long[]{0x4004002020082A08L,0x2000000000000000L,0x0000000800040000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2850 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast2852 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr2879 = new BitSet(new long[]{0x0000000000000002L,0x0000000000A00000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr2889 = new BitSet(new long[]{0x0000000000000002L,0x0000000000A00000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr2904 = new BitSet(new long[]{0x0000000000000002L,0x0000000000A00000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr2934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr2945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr2956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj2982 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2986 = new BitSet(new long[]{0x0000080010040008L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index3006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index3012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_col_alias3027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_col_alias3034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_col_alias3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index3056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range3075 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range3082 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range3087 = new BitSet(new long[]{0x0000080010040008L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_col_ref_in_col_range3094 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj3122 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_pound_proj3126 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_pound_proj3132 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr3152 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr3154 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_bin_expr3161 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_bin_expr3168 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause3202 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause3204 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause3208 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause3218 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause3228 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause3264 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause3266 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause3270 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause3280 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause3326 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause3328 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause3330 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement3356 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement3358 = new BitSet(new long[]{0x0000000000400008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement3362 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause3391 = new BitSet(new long[]{0x0000000000800082L});
    public static final BitSet FOLLOW_ASC_in_rank_by_clause3400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_by_clause3406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause3418 = new BitSet(new long[]{0x0000080010040002L,0x0000000000000000L,0x0000000000001008L});
    public static final BitSet FOLLOW_col_range_in_rank_col3444 = new BitSet(new long[]{0x0000000000800082L});
    public static final BitSet FOLLOW_ASC_in_rank_col3448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_col3452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_rank_col3462 = new BitSet(new long[]{0x0000000000800082L});
    public static final BitSet FOLLOW_ASC_in_rank_col3467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_col3471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_order_clause3501 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause3503 = new BitSet(new long[]{0x0000080010040000L,0x0000008000000000L,0x0000000000001008L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause3505 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_func_clause_in_order_clause3507 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause3534 = new BitSet(new long[]{0x0000000000800082L});
    public static final BitSet FOLLOW_ASC_in_order_by_clause3543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_by_clause3549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause3561 = new BitSet(new long[]{0x0000080010040002L,0x0000000000000000L,0x0000000000001008L});
    public static final BitSet FOLLOW_col_range_in_order_col3587 = new BitSet(new long[]{0x0000000000800082L});
    public static final BitSet FOLLOW_ASC_in_order_col3591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col3595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_order_col3605 = new BitSet(new long[]{0x0000000000800082L});
    public static final BitSet FOLLOW_ASC_in_order_col3610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col3614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause3642 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause3644 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause3646 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause3669 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause3671 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause3693 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause3695 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause3697 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list3725 = new BitSet(new long[]{0x3040090802264002L,0x0080180204004002L,0x0000000000001000L});
    public static final BitSet FOLLOW_JOIN_in_join_clause3764 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause3766 = new BitSet(new long[]{0x0000000000000008L,0x0000000002080000L});
    public static final BitSet FOLLOW_join_type_in_join_clause3768 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause3771 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3807 = new BitSet(new long[]{0x0080020000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_LEFT_in_join_sub_clause3811 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000002000L});
    public static final BitSet FOLLOW_RIGHT_in_join_sub_clause3831 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000002000L});
    public static final BitSet FOLLOW_FULL_in_join_sub_clause3850 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000002000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause3856 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3869 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item3882 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item3884 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item3886 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause3913 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause3917 = new BitSet(new long[]{0x8008088454040008L,0xC020008002500004L,0x000000100118141CL});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr3942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr3948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr3954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause3980 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause3984 = new BitSet(new long[]{0x3040090802264000L,0x0080180204004002L,0x0000000000001000L});
    public static final BitSet FOLLOW_rel_list_in_union_clause3991 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause4027 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause4029 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause4031 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan4067 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan4069 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan4078 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan4080 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk4091 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000000600000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk4094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command4116 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command4118 = new BitSet(new long[]{0x1000010802020000L,0x0000000000004000L,0x0000000000800000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command4120 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command4139 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command4141 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_expr_in_nested_command4143 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op4165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op4173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op4181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op4190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op4198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op4206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op4214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj4238 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4250 = new BitSet(new long[]{0x0000080010040000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4265 = new BitSet(new long[]{0x0000080010040008L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter4318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter4320 = new BitSet(new long[]{0x0000000000000020L,0x000FE00000002FE0L,0x0000000001000402L});
    public static final BitSet FOLLOW_cond_in_nested_filter4322 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort4356 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort4358 = new BitSet(new long[]{0x0000080010040000L,0x0000008000000000L,0x0000000000001008L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort4360 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort4362 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct4392 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct4394 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit4427 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit4429 = new BitSet(new long[]{0x8008088454040000L,0xC020008002500004L,0x0000001001181414L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit4433 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit4444 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross4478 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross4480 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach4512 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach4514 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach4516 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause4545 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause4549 = new BitSet(new long[]{0x8008089454040008L,0xC020008002500004L,0x000000100118141CL});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input4615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input4626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list4652 = new BitSet(new long[]{0x0000080010040002L,0x0000000000000000L,0x0000000000801000L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause4677 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause4679 = new BitSet(new long[]{0x0000000200000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_stream_clause4683 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_IDENTIFIER_in_stream_clause4707 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause4750 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause4778 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause4780 = new BitSet(new long[]{0x0000000000000000L,0x0000080002000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause4782 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause4794 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause4804 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause4811 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause4831 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause4839 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause4857 = new BitSet(new long[]{0x0000000000000008L,0x0000000000008000L,0x0000000020000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause4860 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch4889 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch4891 = new BitSet(new long[]{0x0000000000000020L,0x000FE00000002FE0L,0x0000000001000402L});
    public static final BitSet FOLLOW_cond_in_split_branch4893 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise4927 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise4929 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref4950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref4958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref4975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_alias_col_ref4986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref4997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref5016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr5035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal5053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal5063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal5073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal5083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar5101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar5111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar5122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar5132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar5142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar5167 = new BitSet(new long[]{0x8008008040000000L});
    public static final BitSet FOLLOW_INTEGER_in_num_scalar5180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_num_scalar5194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATNUMBER_in_num_scalar5209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_num_scalar5224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map5257 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map5261 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue5288 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue5290 = new BitSet(new long[]{0x8008008440000000L,0x4020000002000004L,0x0000001001080000L});
    public static final BitSet FOLLOW_literal_in_keyvalue5292 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key5312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag5334 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag5338 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple5370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple5374 = new BitSet(new long[]{0x8008008440000008L,0x4020000002000004L,0x0000001001080000L});
    public static final BitSet FOLLOW_rel_str_op_in_eid5399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid5409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid5419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid5429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid5439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid5449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid5459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid5469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid5479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid5489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid5499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid5509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid5519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid5529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid5539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid5549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid5559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid5569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid5579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid5589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid5599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid5609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid5619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid5629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid5639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid5649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid5659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid5669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid5679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid5689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid5699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid5709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid5719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid5729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid5739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid5749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid5759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid5769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid5779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid5789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid5799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid5809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid5819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid5829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid5839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid5849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid5859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid5869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid5879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid5889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid5899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid5909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid5919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid5929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid5939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid5949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid5959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid5969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid5979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid5989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid5999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid6009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid6019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid6029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid6039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid6049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid6059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid6069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid6079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid6089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid6099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op6111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op6122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op6133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op6144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op6155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op6166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op6177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_str_op6268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_str_op6275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_str_op6282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_str_op6289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_str_op6296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_str_op6303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_str_op6310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred128_LogicalPlanGenerator3208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred129_LogicalPlanGenerator3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred130_LogicalPlanGenerator3270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred160_LogicalPlanGenerator3807 = new BitSet(new long[]{0x0080020000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_set_in_synpred160_LogicalPlanGenerator3809 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000002000L});
    public static final BitSet FOLLOW_OUTER_in_synpred160_LogicalPlanGenerator3856 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_join_item_in_synpred160_LogicalPlanGenerator3859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred177_LogicalPlanGenerator4433 = new BitSet(new long[]{0x0000000000000002L});

}