import sys
import codecs
import DvnToSLP
separators = [u"?", u",", u".", u"|", ]

def translate(inputFile):
	lines = open(inputFile).read()
	# lines = lines.encode("latin1").decode('utf-8')
	#lines = lines.encode('utf-8')
	lines = unicode(lines);
	print repr(lines)
	# for word in lines.split():
		# print DvnToSLP.convertDvnToSLP(word)
	# lines = ''
	# file = codecs.open(inputFile, encoding='latin1')
	# for line in file:
		# print line
		#print line.encode("utf-8")
		#lines = lines +' '+line
	#print lines.encode("utf-8")
	#print DvnToSLP.convertDvnToSLP(lines)
			
	

def main():
	if len(sys.argv) < 5:
		print "Usage run.py input.txt output.txt inputLang outputLand"
		exit(0)
	inputFile = sys.argv[1]
	outputFile = sys.argv[2]
	inputType = sys.argv[3]
	outputType = sys.argv[4]
	translate(inputFile);
	
if __name__=='__main__':
	main()