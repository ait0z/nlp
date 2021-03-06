package oerich.nlputils.classifier;

/**
 * This package is in an inconsistent and experimental state. It basically
 * supports the management of data for the Bayesian and TFxIDF classifiers.
 * <h1>Datamining</h1>
 * <h2>Baysian Filter</h2>
 * Our initial idea was to use Spam-Filter-Technology to classify requirements. We
 * use a baysian filter based on Grahams technical articles. Graham describes, how
 * we could bias the probabilities to increase precision (e.g. counting values of
 * category "ham" twice). Based on this we experimented with biasing the
 * probabilities to increase recall (by favoring "sec" values when computing the
 * baysian probability). Both changes seem to be not beneficial when a good training
 * set is available. Grahams additions do not have any effect in our testdata, our
 * additions give good results with a small training set but tend to classify everything
 * as security relevant with larger ones.
 * <h2>TFxIDF</h2>
 * <p>TFxIDF stands for "Term Frequency" multiplied with "Inverse Document Frequency".
 * It allows to compare and classify a set of documents. It is not really suitable
 * for requirements classification out of the box. We changed this algorithm and
 * only use what we identified as the essence of the algorithm.</p>
 * <p><b>Term Frequency</b> should indicate into what document category (e.g. sec or
 * nonsec) we should classify the given requirement based on the given term (i.e. a
 * word of the requirement). We obtained reasonable result by computing
 * </p><p>
 * <code>TFsec(t) = sec(t) / (sec(t) + nonsec(t))</code>,
 * </p><p>
 * 
 * with TFsec being the Term Frequency for category sec, sec(t) being the number of
 * times t occurred in category sec, and nonsec(t) being the number of time the term
 * occurred in other categories. </p>
 * <p><b>Inverse Document Frequency</b> should indicate how important the given word is
 * for classification. As we understand this, this is a dynamic way to deal with
 * stopwords. We got reasonable results by computing
 * </p><p>
 * <code>IDF(t) = size(R) / size(R(t))</code></p>
 * </p><p>
 * with size(R) being the number of all classified requirements (all categories) and
 * size(R(t)) being the number of all classified requirements (all categories) that
 * contain t. The value is higher for rare terms.</p>
 * 
 * <h2>References</h2>
 * Find some informations about the Baysian Filter in this article by Paul Graham:
 * <a href="http://www.paulgraham.com/spam.html">Ending Spam</a>
 */